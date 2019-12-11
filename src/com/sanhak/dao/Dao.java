package com.sanhak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sanhak.dto.LostitemDto;
import com.sanhak.dto.commonDto;
import com.sanhak.dto.getitemDto;
import com.sanhak.dto.indiReplyDto;
import com.sanhak.dto.indilostitemDto;
import com.sanhak.dto.memberDto;
import com.sanhak.dto.searchDto;


public class Dao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs =null;
	
	private final String INSERT_MEMBER_SQL = "INSERT INTO member "
											+ "(mid,password,name,mtel,email)"
											+ " values (?,?,?,?,?)";
	private final String CHECK_LOGIN_SQL= "SELECT * "
											+ "FROM member "
											+ "where mid=?";
	private final String REGISTERCHECK_SQL="SELECT * FROM member WHERE mid=?";
	
	private final String MYPAGE_SQL = "SELECT * FROM member WHERE mid=?";
	
	private final String MYPAGE_UPDATE_SQL="UPDATE member SET password=?,mtel=?,email=?,name=? WHERE mid=?";
	private final String MYPAGE_DELETE_SQL="DELETE FROM member WHERE mid=?";
	
	private final String VIEW_MEMBER_SQL = "SELECT mid,name FROM member";
	
	private final String VIEW_PERSONAL_MEMBER_SQL = "SELECT password,mtel,email,name FROM member WHERE mid = ?";

	private final String UPDATE_MEMBER_SQL = "update member SET password = ?, mtel = ?, email = ?, name=? where mid = ?";

	private final String DELETE_MEMBER_SQL = "delete from member where mid = ?";
	
	private final String GET_ORGCODE_SQL = "select * from common where substr(code,1,2)='01'or substr(code,1,2)='02' or substr(code,1,2)='03'";
	
	private final String GET_PRDTCODE_SQL="select * from common where substr(code,1,2)='09'";
	
	private final String SEARCH_LOSTITEM_ALL_SQL ="select lostid, prdtname, location ,co.name,co.etc,lstymd" 
													+" from lostitem lost join common co on (lost.orgid=co.code)"
													+"where lost.location like ? and lost.orgid like ? and lost.prdtid like ? and lost.prdtname like ? and lost.status ='1' ";
	private final String GET_COMMON_CODE_SQL = "select * from common where substr(code,1,2)='09'";
	private final String SEARCH_LOSTITEM_SQL = "select lostid, prdtname, location ,co.name,co.etc,lstymd "
												+ "	from lostitem lost join common co on (lost.orgid=co.code)"
												+ "	where lost.location like ? and lost.orgid like ? and lost.prdtid like ? and lost.lstymd between ? and ? and lost.prdtname like ? and lost.status ='1'";
	
	private final String SHOW_LOSTITEM_UPDATE_SQL = "select *,co1.name prdt,co2.name org ,co2.etc coetc from lostitem join common co1 on (prdtid=co1.code) join common co2 on(orgid=co2.code) where lostid=?";
	
	private final String UPDATE_LOSTITEM_SQL="update lostitem SET hor = ?, prdtname =?, location = ? , place = ?, sector = ?, content = ?, status = ?, lstymd = ?, prdtid=?, orgid=? WHERE lostid = ?";
	
	private final String INSERT_RELAY_SQL ="insert INTO getitem (lostid, mid, getdate) values(?,?,?)";
	
	private final String UPDATE_RELAY_SQL ="UPDATE lostitem SET status=2 WHERE lostid=?";
	
	private final String DELETE_INDILOSTITEM_SQL = "delete from indilostitem where inum = ?";
	
	private final String INDILOSTITEM_SQL = "select inum, mid, iprdtname, ilocation, iplace, isector, iunique, istatus, title, postdate, lstdate from indilostitem";
	
	private final String INDILOSTITEMINFO_SQL = "select co.name,inum, mid, iprdtname, ilocation, iplace, isector, iunique, istatus, title, postdate, lstdate, hor, pathimg from indilostitem indi JOIN common co ON (indi.iprdtid=co.code) WHERE inum = ?";
	
	private final String UPDATE_INDILOSTITEM_SQL = "update indilostitem SET iprdtname = ?, ilocation = ?, iplace = ?, isector = ?, iunique = ?, istatus = ?, title = ?, postdate = ?, lstdate = ?,iprdtid=? ,pathImg = ? where inum=?";
	   
	private final String VIEW_UPINDILOST_SQL = "SELECT inum, mid, iprdtname, ilocation, iplace, isector, iunique, istatus, title, postdate, lstdate from indilostitem";
	
	private final String INSERT_INDILOSTITEM_SQL="INSERT INTO indilostitem(mid, lstdate, postdate, iprdtname, ilocation, iplace, isector, iunique, pathImg, hor, iprdtid, title) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String INSERT_INDIREPLY_SQL ="INSERT INTO indireply( mid, redate, reply, inum) VALUES(?,?,?,?)";
	
	private final String VIEW_INDIREPLY_SQL="SELECT * from indireply where inum = ?";
	
	private final String UPDATE_INDIREPLY_SQL="UPDATE indireply SET redate = ? ,reply = ? WHERE reid = ?";
	
	private final String DELETE_INDIREPLY_SQL="DELETE from indireply WHERE reid = ? ";
	
	private final String GET_RELAY_LIST_SQL ="select * from getitem geti JOIN lostitem lost ON(geti.lostid = lost.lostId) ;";
	
	private final String GET_RECENT_LOSTITEM_COMMAND_8_KMJ = "SELECT * from lostitem order by lstymd desc LIMIT 8";
	
	private final String SHOW_MYBOARD_SQL="SELECT title, inum FROM indilostitem WHERE mid=? ";
	   
	private final String SHOW_MYREPLY_SQL="SELECT reply, inum FROM indireply WHERE mid=?";
	
	public int join(memberDto dto) {
		try {
			
			DBconn dbconn = new DBconn();		//db connection
			conn = dbconn.getDBConn();	
			
			stmt = conn.prepareStatement(INSERT_MEMBER_SQL);
			stmt.setString(1, dto.getMid());
			stmt.setString(2, dto.getPassword());
			stmt.setString(3, dto.getName());
			stmt.setString(4, dto.getMtel());
			stmt.setString(5, dto.getEmail());
			stmt.executeUpdate();
			return 2;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1;//오류 발생할 경우
	}
	public int registerCheck(String userID) {
		
		try {
			DBconn dbconn = new DBconn();		//db connection 
			conn = dbconn.getDBConn();	
			
			stmt = conn.prepareStatement(REGISTERCHECK_SQL);
			stmt.setString(1, userID);
			rs = stmt.executeQuery();
			if(rs.next()||userID.equals("")) {
				return 0;
			}else{
				return 1;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null)rs.close();
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	public memberDto login(memberDto dto) {
		try {
			
			DBconn dbconn = new DBconn();		//db connection �������� ��ü ����
			conn = dbconn.getDBConn();	
			
			stmt = conn.prepareStatement(CHECK_LOGIN_SQL);
			stmt.setString(1, dto.getMid());
			rs=stmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("password").equals(dto.getPassword())) {
					dto.setResult(1);
					int mgrant = rs.getInt("mgrant");
					dto.setMgrant(mgrant);
					String id = rs.getString("mid");
					dto.setMid(id);
					return dto;
					
				}else {
					dto.setResult(0);
					return dto;
				}
			}dto.setResult(-1);
			return dto;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		dto.setResult(-2);//오류 발생할 경우
		return dto;
	}
	
public memberDto mypage(String id) {
	memberDto dto = new memberDto();
		try {
			DBconn dbconn = new DBconn();		//db connection 
			conn = dbconn.getDBConn();	
			
			
			stmt = conn.prepareStatement(MYPAGE_SQL);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				String mid = rs.getString("mid");
				String password = rs.getString("password");
				String mtel = rs.getString("mtel");
				String email = rs.getString("email");
				String name = rs.getString("name");
				
				dto.setMid(mid);
				dto.setPassword(password);
				dto.setMtel(mtel);
				dto.setEmail(email);
				dto.setName(name);
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null)rs.close();
				if(stmt !=null)stmt.close();
				if(conn !=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public void MyPageUpdate(memberDto dto) {
		
		try {
			
			DBconn dbconn = new DBconn();		//db connection �������� ��ü ����
			conn = dbconn.getDBConn();	
			
			stmt = conn.prepareStatement(MYPAGE_UPDATE_SQL);
			stmt.setString(1, dto.getPassword());
			stmt.setString(2, dto.getMtel());
			stmt.setString(3, dto.getEmail());
			stmt.setString(4, dto.getName());
			stmt.setString(5, dto.getMid());
			stmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public int deleteMypage(String UserId) {
	      try {
	         DBconn dbconn = new DBconn();      
	         conn = dbconn.getDBConn();
	         
	         stmt = conn.prepareStatement(MYPAGE_DELETE_SQL);
	         stmt.setString(1, UserId);
	         stmt.executeUpdate();
	        return 1;
	      }catch(Exception e){
	         e.printStackTrace();
	      }finally {
	         try {
	            if(rs !=null)rs.close();
	            if(stmt !=null)stmt.close();
	            if(conn !=null)conn.close();
	         }catch(Exception e) {
	            e.printStackTrace();
	         }
	      }
	      return -1;
	   }
/* minjung's coding */	
	
	public ArrayList<memberDto> viewMember() {
		
		ArrayList<memberDto> dtos = new ArrayList<memberDto>();
		DBconn dbconn = new DBconn();//db 접속 객체
		try {
			conn = dbconn.getDBConn();
			//private final String VIEW_MEMBER_SQL="SELECT mid,name FROM member";
			stmt = conn.prepareStatement(VIEW_MEMBER_SQL);
			rs = stmt.executeQuery();
			while(rs.next()) {
				String mid = rs.getString("mid");
				String name = rs.getString("name");
				
				memberDto dto = new memberDto();
	            dto.setMid(mid);
	            dto.setName(name);
	            dtos.add(dto);

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
		
	}
	
public memberDto updateMember(String id) {
		System.out.println(id);
		memberDto dto = new memberDto();
		DBconn dbconn = new DBconn();//db 접속 객체
		try {
			conn = dbconn.getDBConn();
			//private final String VIEW_PERSONAL_MEMBER_SQL = "SELECT password,mtel,email FROM member WHERE mid = ?";
			stmt = conn.prepareStatement(VIEW_PERSONAL_MEMBER_SQL);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
			String password = rs.getString("password");	
			String mtel = rs.getString("mtel");
			String email = rs.getString("email");
			String name = rs.getString("name");
			
			dto.setMid(id);
			dto.setPassword(password);
			dto.setMtel(mtel);
			dto.setEmail(email);
			dto.setName(name);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
		
	}

public memberDto updateMember(memberDto dto) {

	DBconn dbconn = new DBconn();//db 접속 객체
	try {
		conn = dbconn.getDBConn();
		//UPDATE_MEMBER_SQL = "update member set password = ?, mtel = ?, name = ? where mid = ?";
		stmt = conn.prepareStatement(UPDATE_MEMBER_SQL);
		
		stmt.setString(1, dto.getPassword());
		stmt.setString(2, dto.getMtel());
		stmt.setString(3, dto.getEmail());
		stmt.setString(4, dto.getName());
		stmt.setString(5, dto.getMid());
		
		stmt.executeUpdate();	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return dto;
	
}
	

public memberDto deleteMember(String id) {
	// TODO Auto-generated method stub
	DBconn dbconn = new DBconn();//db 접속 객체
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(DELETE_MEMBER_SQL);	
		stmt.setString(1, id);

		stmt.executeUpdate();	
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return null;
}

/* minjung's coding */

public ArrayList<commonDto> getOrg(){
	ArrayList<commonDto> orgDtos = new ArrayList<commonDto>();
	DBconn dbconn = new DBconn();//db 접속 객체
	try {
		conn = dbconn.getDBConn();
		//private final String VIEW_MEMBER_SQL="SELECT mid,name FROM member";
		stmt = conn.prepareStatement(GET_ORGCODE_SQL);
		rs = stmt.executeQuery();
		while(rs.next()) {
			String code = rs.getString("code");
			String name = rs.getString("name");
			String etc = rs.getString("etc");
			
			commonDto dto = new commonDto();
			
            dto.setCode(code);;
            dto.setName(name);
            dto.setEtc(etc);
            orgDtos.add(dto);

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return orgDtos;
	}
public ArrayList<commonDto> getPrdt(){
	ArrayList<commonDto> prdtDtos = new ArrayList<commonDto>();
	DBconn dbconn = new DBconn();//db 접속 객체
	try {
		conn = dbconn.getDBConn();
		//private final String VIEW_MEMBER_SQL="SELECT mid,name FROM member";
		stmt = conn.prepareStatement(GET_PRDTCODE_SQL);
		rs = stmt.executeQuery();
		while(rs.next()) {
			String code = rs.getString("code");
			String name = rs.getString("name");
			
			commonDto dto = new commonDto();
			
            dto.setCode(code);;
            dto.setName(name);
            prdtDtos.add(dto);

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return prdtDtos;
	}

public ArrayList<LostitemDto> search(searchDto dto){
	ArrayList<LostitemDto> resultDtos = new ArrayList<LostitemDto>();
	DBconn dbconn = new DBconn();//db 접속 객체
	try {
		
		conn = dbconn.getDBConn();
		//private final String VIEW_MEMBER_SQL="SELECT mid,name FROM member";
		if(dto.getLostdate1()=="") {
			stmt = conn.prepareStatement(SEARCH_LOSTITEM_ALL_SQL);
			stmt.setString(1,dto.getLocation());
			stmt.setString(2,dto.getOrgid());
			stmt.setString(3,dto.getPrdtid());
			stmt.setString(4,dto.getPrdtname());
		}else {
			stmt = conn.prepareStatement(SEARCH_LOSTITEM_SQL);
			stmt.setString(1,dto.getLocation());
			stmt.setString(2,dto.getOrgid());
			stmt.setString(3,dto.getPrdtid());
			stmt.setString(4,dto.getLostdate1());
			stmt.setString(5,dto.getLostdate2());
			stmt.setString(6,dto.getPrdtname());
		}
		System.out.println(stmt);
		rs = stmt.executeQuery();
		while(rs.next()) {
			
			LostitemDto ldto =new LostitemDto();
			ldto.setLostId(rs.getInt("lostId"));
			ldto.setPrdtname(rs.getString("prdtname"));
			ldto.setLocation(rs.getString("location"));;
			ldto.setConame(rs.getString("name"));
			ldto.setEtc(rs.getString("etc"));;
			ldto.setLstymd(rs.getString("lstymd").toString());
		
            resultDtos.add(ldto);

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return resultDtos;
	}
public LostitemDto showLostItem(int lostid) {
	   LostitemDto dto = new LostitemDto();
	   try {
	      DBconn dbconn = new DBconn();      //db connection 
	      conn = dbconn.getDBConn();   
	      
	      
	      stmt = conn.prepareStatement(SHOW_LOSTITEM_UPDATE_SQL);
	      stmt.setInt(1, lostid);
	      System.out.println("show lostitem sql =>"+stmt);
	      rs = stmt.executeQuery();
	      
	      if(rs.next()) {
	    	 dto.setPrdtname(rs.getString("prdtname"));
	         dto.setLostId(rs.getInt("lostid"));
	         dto.setHor(rs.getInt("hor"));
	         dto.setLocation(rs.getString("location"));
	         dto.setPlace(rs.getString("place"));
	         dto.setSector(rs.getString("sector"));
	         dto.setContent(rs.getString("content"));
	         dto.setStatus(rs.getString("status"));
	         dto.setLstymd(rs.getString("lstymd"));
	         dto.setPrdtid(rs.getString("prdt"));
	         dto.setOrgid(rs.getString("org"));
	         dto.setEtc(rs.getString("coetc"));
	         dto.setPathImg(rs.getString("pathimg"));
	         
	      }
	      
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally {
	      try {
	         if(rs !=null)rs.close();
	         if(stmt !=null)stmt.close();
	         if(conn !=null)conn.close();
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	   }
	   return dto;
	   
	}

public void updateLostItem(LostitemDto dto) {

	   DBconn dbconn = new DBconn();//db �
	   try {
	      conn = dbconn.getDBConn();
	   
	      stmt = conn.prepareStatement(UPDATE_LOSTITEM_SQL);
	      
	      stmt.setInt(1,dto.getHor());
	      stmt.setString(2,dto.getPrdtname());
	      stmt.setString(3,dto.getLocation());
	      stmt.setString(4,dto.getPlace());
	      stmt.setString(5,dto.getSector());
	      stmt.setString(6,dto.getContent());
	      stmt.setString(7,dto.getStatus());
	      stmt.setString(8,dto.getLstymd());
	      stmt.setString(9,dto.getPrdtid());
	      stmt.setString(10, dto.getOrgid());
	      stmt.setInt(11,dto.getLostId());
	      System.out.println("update lostitem sql =>"+stmt);
	      
	      stmt.executeUpdate();   
	      
	   } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }finally {
	      try {
	         if(rs!=null)rs.close();
	         if(stmt!=null)stmt.close();
	         if(conn!=null)conn.close();
	      }catch(Exception e2) {
	         e2.printStackTrace();
	      }
	   }
	    
	}
public int RelayLostitem(getitemDto dto) {

	   DBconn dbconn = new DBconn();//db �
	   try {
	      conn = dbconn.getDBConn();
	   
	      stmt = conn.prepareStatement(INSERT_RELAY_SQL);
	      stmt.setInt(1, dto.getLostid());
	      stmt.setString(2, dto.getMid());
	      stmt.setString(3, dto.getGetdate());
	      
	     
	      System.out.println("update lostitem sql =>"+stmt);
	      
	      stmt.executeUpdate();  
	      stmt= conn.prepareStatement(UPDATE_RELAY_SQL);
	      stmt.setInt(1, dto.getLostid());
	      stmt.executeUpdate();
	      return 2;
	      
	   } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }finally {
	      try {
	         if(stmt!=null)stmt.close();
	         if(conn!=null)conn.close();
	      }catch(Exception e2) {
	         e2.printStackTrace();
	      }
	   }
	    return -1;
	}
public ArrayList<indilostitemDto> list(){
	ArrayList<indilostitemDto> dtos = new ArrayList<indilostitemDto>();
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(INDILOSTITEM_SQL);
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			int inum = rs.getInt("inum");
			String mid = rs.getString("mid");
			String iprdtname = rs.getString("iprdtname");
			String ilocation = rs.getString("ilocation");
			String iplace = rs.getString("iplace");
			String isector = rs.getString("isector");
			String iunique = rs.getString("iunique");
			String istatus = rs.getString("istatus");
			String title = rs.getString("title");
			String postdate = rs.getString("postdate");
			String lstdate = rs.getString("lstdate");
			
			
			indilostitemDto dto = new indilostitemDto();
			dto.setInum(inum);
			dto.setMid(mid);
			dto.setIprdtname(iprdtname);
			dto.setIlocation(ilocation);
			dto.setIplace(iplace);
			dto.setIsector(isector);
			dto.setIunique(iunique);
			dto.setIstatus(istatus);
			dto.setTitle(title);
			dto.setPostdate(postdate);
			dto.setLstdate(lstdate);
			
			dtos.add(dto);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return dtos;
}

public indilostitemDto indilostiteminfo(int inum) {
	
	DBconn dbconn = new DBconn();
	indilostitemDto dto = new indilostitemDto();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(INDILOSTITEMINFO_SQL);
		stmt.setInt(1, inum);
		System.out.println("indilostitem info sql =>"+stmt);
		rs = stmt.executeQuery();
		while(rs.next()) {
		String title= rs.getString("title");
		String mid = rs.getString("mid");
		String iprdtname = rs.getString("iprdtname");
		String ilocation = rs.getString("ilocation");
		String iplace = rs.getString("iplace");
		String isector = rs.getString("isector");
		String iunique = rs.getString("iunique");
		String istatus = rs.getString("istatus");
		String postdate = rs.getString("postdate");
		String lstdate = rs.getString("lstdate");
		String iprdtid = rs.getString("name");
		String pathimg = rs.getString("pathimg");
		int hor = rs.getInt("hor");
		
		dto.setInum(inum);
		dto.setMid(mid);
		dto.setIprdtname(iprdtname);
		dto.setIlocation(ilocation);
		dto.setIplace(iplace);
		dto.setIsector(isector);
		dto.setIunique(iunique);
		dto.setIstatus(istatus);
		dto.setTitle(title);
		dto.setPostdate(postdate);
		dto.setLstdate(lstdate);
		dto.setIprdtid(iprdtid);
		dto.setPathImg(pathimg);
		dto.setHor(hor);
		

		}
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return dto;
}
public indilostitemDto updateIndilostitem(indilostitemDto dto) {
	   SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	   String now = sdf.format(new Date().getTime());
	   System.out.println("updateIndilostitem : "+now);
	   DBconn dbconn = new DBconn();
	   try {
	      conn = dbconn.getDBConn();
	      
	      stmt = conn.prepareStatement(UPDATE_INDILOSTITEM_SQL);
	      stmt.setString(1, dto.getIprdtname());
	      stmt.setString(2, dto.getIlocation());
	      stmt.setString(3, dto.getIplace());
	      stmt.setString(4, dto.getIsector());
	      stmt.setString(5, dto.getIunique());
	      stmt.setString(6, dto.getIstatus());
	      stmt.setString(7, dto.getTitle());
	      stmt.setString(8, now);
	      stmt.setString(9, dto.getLstdate());
	      stmt.setString(10, dto.getIprdtid());
	      stmt.setString(11, dto.getPathImg());
	      stmt.setInt(12, dto.getInum());
	      System.out.println("stmt :"+stmt);
	      stmt.executeUpdate();   
	      
	   } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }finally {
	      try {
	         if(stmt!=null)stmt.close();
	         if(conn!=null)conn.close();
	      }catch(Exception e2) {
	         e2.printStackTrace();
	      }
	   }
	   return dto;
	}

public ArrayList<indilostitemDto> Viewindilost() {
	
	ArrayList<indilostitemDto> dtos = new ArrayList<indilostitemDto>();
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
	
		stmt = conn.prepareStatement(VIEW_UPINDILOST_SQL);
		rs = stmt.executeQuery();
		while(rs.next()) {
			int inum = rs.getInt("inum");
			String mid = rs.getString("mid");
			String iprdtname = rs.getString("iprdtname");
			String title = rs.getString("title");
			String ilocation = rs.getString("ilocation");
			String iplace = rs.getString("iplace");
			String isector = rs.getString("isector");
			String iunique = rs.getString("iunique");
			String istatus = rs.getString("istatus");
			String postdate = rs.getString("postdate");
			String lstdate = rs.getString("lstdate");
			
			indilostitemDto dto = new indilostitemDto();
			dto.setInum(inum);
			dto.setMid(mid);
			dto.setIprdtname(iprdtname);
			dto.setIlocation(ilocation);
			dto.setIplace(iplace);
			dto.setIsector(isector);
			dto.setIunique(iunique);
			dto.setIstatus(istatus);
			dto.setTitle(title);
			dto.setPostdate(postdate);
			dto.setLstdate(lstdate);
			dtos.add(dto);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return dtos;
	
}

public indilostitemDto deleteIndilostItem(int inum) {
	// TODO Auto-generated method stub
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(DELETE_INDILOSTITEM_SQL);	
		stmt.setInt(1, inum);
		stmt.executeUpdate();	

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return null;
}
public ArrayList<commonDto> getCommonCode() {
    ArrayList<commonDto> dtos = new ArrayList<commonDto>();
    DBconn dbconn = new DBconn();
    try {
       
       conn = dbconn.getDBConn();
       stmt = conn.prepareStatement(GET_COMMON_CODE_SQL);
       rs = stmt.executeQuery();
       while(rs.next()) {
          String code = rs.getString("code");
          String name = rs.getString("name");
          
          commonDto dto = new commonDto();
          dto.setCode(code);
          dto.setName(name);
          
           dtos.add(dto);
       
          }
       
    } catch (Exception e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
    }finally {
       try {
          if(rs!=null)rs.close();
          if(stmt!=null)stmt.close();
          if(conn!=null)conn.close();
       }catch(Exception e2) {
          e2.printStackTrace();
       }
    }
    return dtos;
 }
public int insertIndiLostitem(indilostitemDto dto) {
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(INSERT_INDILOSTITEM_SQL);
//"INSERT INTO indilostitem(mid, lstdate, postdate, iprdtname, ilocation, iplace, isector, iunique, pathImg, hor, iprdtid, title) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		stmt.setString(1, dto.getMid());
		stmt.setString(2, dto.getLstdate());
		stmt.setString(3, dto.getPostdate());
		stmt.setString(4, dto.getIprdtname());
		stmt.setString(5, dto.getIlocation());
		stmt.setString(6, dto.getIplace());
		stmt.setString(7, dto.getIsector());
		stmt.setString(8, dto.getIunique());
		stmt.setString(9, dto.getPathImg()); 
		stmt.setInt(10, dto.getHor());
		stmt.setString(11, dto.getIprdtid());
		stmt.setString(12, dto.getTitle());
		
		System.out.println("dao.dto tostring==>"+dto.toString());
		System.out.println(stmt);
		stmt.executeUpdate();
		return 2;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return -1;
}
public void insertIndiReply(indiReplyDto dto) {
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(INSERT_INDIREPLY_SQL);
		
		stmt.setString(1, dto.getMid());
		stmt.setString(2, dto.getRedate());
		stmt.setString(3, dto.getReply());
		stmt.setString(4, dto.getInum());
		System.out.println("insert Indi reply sql==>"+stmt);
		stmt.executeUpdate();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
}
public ArrayList<indiReplyDto> viewIndiReply(String inum){
	ArrayList<indiReplyDto> dtos = new ArrayList<indiReplyDto>();
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(VIEW_INDIREPLY_SQL);
		
		stmt.setString(1, inum);
		System.out.println("viewIndiReply sql =>"+stmt);
		rs = stmt.executeQuery();
		System.out.println(stmt);
		
		while(rs.next()) {
			String reId = rs.getString("reId");
			String mid = rs.getString("mid");
			String redate = rs.getString("redate");
			String reply = rs.getString("reply");
			
			indiReplyDto dto = new indiReplyDto();
			
			dto.setReid(reId);
			dto.setMid(mid);
			dto.setRedate(redate);
			dto.setReply(reply);
			
			dtos.add(dto);
		
			}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return dtos;
}
public void updateIndireply(indiReplyDto dto) {
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(UPDATE_INDIREPLY_SQL);
		
		stmt.setString(1, dto.getRedate());
		stmt.setString(2, dto.getReply());
		stmt.setString(3, dto.getReid()+"");
		
		stmt.executeUpdate();
		System.out.println(dto.toString());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
}
public void deleteIndireply(int reid){
	DBconn dbconn = new DBconn();
	try {
		conn = dbconn.getDBConn();
		stmt = conn.prepareStatement(DELETE_INDIREPLY_SQL);
		System.out.println("reid is "+reid);
		stmt.setInt(1, reid);
		System.out.println("deleteIndireply sql =>"+stmt);
		stmt.executeUpdate();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
}
public ArrayList<getitemDto> getRelayList() {
	
	ArrayList<getitemDto> dtos = new ArrayList<getitemDto>();
	DBconn dbconn = new DBconn();//db 접속 객체
	try {
		conn = dbconn.getDBConn();
		//private final String VIEW_MEMBER_SQL="SELECT mid,name FROM member";
		stmt = conn.prepareStatement(GET_RELAY_LIST_SQL);
		rs = stmt.executeQuery();
		while(rs.next()) {
			String mid = rs.getString("mid");
			int lostid = rs.getInt("lostid");
			String getdate = rs.getString("getdate");
			String prdtname = rs.getString("prdtname");
			
			getitemDto dto = new getitemDto();
			dto.setMid(mid);
			dto.setLostid(lostid);
			dto.setGetdate(getdate);
			dto.setPrdtname(prdtname);
            dtos.add(dto);

		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	return dtos;
	
}
public ArrayList<LostitemDto> getRecentLostitemCommand_8_KMJ() {
    
    ArrayList<LostitemDto> dtos = new ArrayList<LostitemDto>();
    System.out.println("get_recent_lostitem()");
    DBconn dbconn = new DBconn();
    
    try {
       conn = dbconn.getDBConn();
       
       //private final String GET_RECENT_LOSTITEM_COMMAND_8_KMJ = "SELECT * from lostitem order by `lstymd` desc LIMIT 8";

       stmt = conn.prepareStatement(GET_RECENT_LOSTITEM_COMMAND_8_KMJ);
       rs = stmt.executeQuery();
       
       while(rs.next()) {
          String prdtname = rs.getString("prdtname");
          String lstymd = rs.getString("lstymd");
          String pathimg = rs.getString("pathimg");
          int lostid = rs.getInt("lostid");
          
          System.out.println(prdtname);
          System.out.println(lstymd);
          System.out.println(pathimg);
          
          LostitemDto dto = new LostitemDto();
          
             dto.setPrdtname(prdtname);
             dto.setLstymd(lstymd);
             dto.setPathImg(pathimg);
             dto.setLostId(lostid);
             dtos.add(dto);

       }
       
    } catch (Exception e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
    }finally {
       try {
          if(stmt!=null)stmt.close();
          if(conn!=null)conn.close();
       }catch(Exception e2) {
          e2.printStackTrace();
       }
    }
    
    return dtos;
    
 }
public ArrayList<indilostitemDto> showTitle(String mid) {
	   ArrayList<indilostitemDto> ssdto = new ArrayList<indilostitemDto>();
	   DBconn dbconn = new DBconn();
	   try {
	      System.out.println("showtitle");
	      conn = dbconn.getDBConn();
	      
	      stmt = conn.prepareStatement(SHOW_MYBOARD_SQL);
	      stmt.setString(1, mid);
	      System.out.println("show title sql=>"+stmt);
	      rs = stmt.executeQuery();
	      while(rs.next()) {
	         
	      String title = rs.getString("title");
	      int inum = rs.getInt("inum");
	      indilostitemDto adto = new indilostitemDto();
	      
	      adto.setMid(mid);
	      adto.setInum(inum);
	      adto.setTitle(title);
	      
	      ssdto.add(adto);
	      
	      }
	   } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }finally {
	      try {
	         if(rs!=null)rs.close();
	         if(stmt!=null)stmt.close();
	         if(conn!=null)conn.close();
	      }catch(Exception e2) {
	         e2.printStackTrace();
	      }
	   }
	   return ssdto;
	}
public ArrayList<indiReplyDto> showReply(String mid) {
	   ArrayList<indiReplyDto> ssdto = new ArrayList<indiReplyDto>();
	   DBconn dbconn = new DBconn();
	   try {
	      conn = dbconn.getDBConn();

	      stmt = conn.prepareStatement(SHOW_MYREPLY_SQL);
	      stmt.setString(1, mid);

	      rs = stmt.executeQuery();
	      while(rs.next()) {
	         
	      String reply = rs.getString("reply");
	      String inum = rs.getString("inum");
	      indiReplyDto adto = new indiReplyDto();
	      
	      adto.setMid(mid);
	      adto.setInum(inum);
	      adto.setReply(reply);
	      
	      ssdto.add(adto);

	      
	      }
	   } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	   }finally {
	      try {
	         if(rs!=null)rs.close();
	         if(stmt!=null)stmt.close();
	         if(conn!=null)conn.close();
	      }catch(Exception e2) {
	         e2.printStackTrace();
	      }
	   }
	   return ssdto;
	}
}

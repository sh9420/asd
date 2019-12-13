package com.sanhak.command;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;

import com.sanhak.dao.Dao;
import com.sanhak.dto.commonDto;
import com.sanhak.dto.indilostitemDto;
import com.sanhak.dto.memberDto;

import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.MultipartResponse;

public class InsertLostitemCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("deprecation")
		String uploadPath = request.getRealPath("/uploads");
		System.out.println("업로드 path : " + uploadPath);
		
		int maxSize = 1024 * 1024 * 10;
	
		HttpSession session = request.getSession();
		memberDto mdto = (memberDto)session.getAttribute("Lresult");
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(new java.util.Date());

		 //file parameter
		 String pathImg = ""; 
		 String originalpathImg = ""; 
		 long fileSize = 0;
		 String fileType = ""; 
		     
		 MultipartRequest multi = null;
		 
		 try {
			multi = new MultipartRequest(request,uploadPath,maxSize,"UTF-8",new DefaultFileRenamePolicy());
			
			//get parameter
			System.out.println("등록자 : "+mdto.getMid());
			request.setCharacterEncoding("utf-8");
			
			String mid = mdto.getMid();
			String postdate = today;
			String title = multi.getParameter("title");
			String iprdtname = multi.getParameter("iprdtname");
			int hor = Integer.parseInt(multi.getParameter("hor"));
			String lstdate = multi.getParameter("lstdate");
			String ilocation = multi.getParameter("ilocation");
			String iplace = multi.getParameter("iplace");
			String isector = multi.getParameter("isector");
			String iprdtid = multi.getParameter("iprdtid");
			String iunique = multi.getParameter("iunique");
			
			
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
			
				String file1 = (String)files.nextElement();
		
				originalpathImg = multi.getOriginalFileName(file1);
				
				pathImg = multi.getFilesystemName(file1);
				System.out.println("pathImg >>>"+pathImg);
				if(pathImg==null) {
					pathImg="https://www.lost112.go.kr/lostnfs/images/sub/img04_no_img.gif";
					break;
				}
				fileType = multi.getContentType(file1);
			
				File file = multi.getFile(file1);
				
				fileSize = file.length();
				
				pathImg = "uploads/"+ pathImg;
				session.setAttribute("img", pathImg );
			}
			indilostitemDto dto = new indilostitemDto();
			
			dto.setHor(hor);
			dto.setIlocation(ilocation);
			dto.setIplace(iplace);
			dto.setIprdtid(iprdtid);
			dto.setIprdtname(iprdtname);
			dto.setIsector(isector);
			dto.setIunique(iunique);
			dto.setLstdate(lstdate);
			dto.setMid(mid);
			dto.setPathImg(pathImg);
			dto.setPostdate(postdate);
			dto.setTitle(title);
			
			System.out.println(dto.toString());
			
			Dao dao = new Dao();
			dao.insertIndiLostitem(dto);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

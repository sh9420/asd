package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.searchDto;

public class SearchCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String prdtid = request.getParameter("prdtid");
		String location = request.getParameter("location");
		String lostdate1 = request.getParameter("lostdate1");
		String lostdate2 = request.getParameter("lostdate2");
		String orgid = request.getParameter("orgid");
		String prdtname = request.getParameter("prdtname");
		
		searchDto dto = new searchDto();
		//if()
		
		if(prdtid.equals("1")) {
			
			prdtid="%";
		}
		System.out.println("prdtid="+prdtid);
		dto.setPrdtid(prdtid);
		
		if(location.equals("1")) {
			location="%";
		}
		System.out.println("location="+location);
		dto.setLocation(location);
		System.out.println("lostdate1="+lostdate1);
		if(lostdate1.equals("")) {
			System.out.println("로스트데이트1 없음");
		}
		dto.setLostdate1(lostdate1);
		System.out.println("lostdate2="+lostdate2);
		dto.setLostdate2(lostdate2);
		
		if(orgid.equals("1"))
		{
			orgid="%";
		}
		System.out.println("orgid="+orgid);
		dto.setOrgid(orgid);
		System.out.println("prdtname="+prdtname);
		prdtname="%"+prdtname+"%";
		dto.setPrdtname(prdtname);
		
		Dao dao = new Dao();	
		HttpSession session = request.getSession();
		session.setAttribute("searchresult", dao.search(dto));
	}

	
}

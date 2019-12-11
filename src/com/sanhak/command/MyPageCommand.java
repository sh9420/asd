package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class MyPageCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		memberDto dto = (memberDto)session.getAttribute("Lresult");
		String mid = dto.getMid();
		
		Dao dao = new Dao();
		memberDto mdto =new memberDto();
		mdto = dao.mypage(mid); 
		session.setAttribute("memberinfo", mdto);
		
	}

	
}

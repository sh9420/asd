package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class LoginCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("id");
		String password = request.getParameter("password");
		
		memberDto dto = new memberDto();
		dto.setMid(mid);
		dto.setPassword(password);
		
		Dao dao = new Dao();
		dto = dao.login(dto);
		
		System.out.println(dto.getResult());
		HttpSession session = request.getSession();
		session.setAttribute("Lresult", dto);
	
		
	}
	
	

}

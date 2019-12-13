package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class MyPageUpdateCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		String mid = request.getParameter("mid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String mtel = request.getParameter("mtel");
		String email = request.getParameter("email");
		
		memberDto dto = new memberDto();
		dto.setMid(mid);
		dto.setPassword(password);
		dto.setName(name);
		dto.setMtel(mtel);
		dto.setEmail(email);
		
		Dao dao = new Dao();
		dao.MyPageUpdate(dto);
		
		
	}

	
}

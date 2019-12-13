package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class SignUpCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("id");
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
		dto.setResult(dao.registerCheck(dto.getMid()));
		System.out.println("aaa:"+dto.getResult());
		if(dto.getResult()==1) {
		dto.setResult(dao.join(dto));
		}
		HttpSession session = request.getSession();
		session.setAttribute("result", dto);
		
		System.out.println(dto.getResult());
	}

	
}

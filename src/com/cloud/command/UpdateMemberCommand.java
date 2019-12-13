package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class UpdateMemberCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("id");
		String password = request.getParameter("password");
		String mtel = request.getParameter("mtel");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		memberDto dto = new memberDto();
		dto.setMid(mid);
		dto.setPassword(password);
		dto.setMtel(mtel);
		dto.setEmail(email);
		dto.setName(name);
		
		Dao dao = new Dao();
		dao.updateMember(dto);
		
	}

}

package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class VeiwMemberCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Dao dao = new Dao();
		HttpSession session = request.getSession();
		session.setAttribute("allviewMember", dao.viewMember());
		
		
		
	}

}

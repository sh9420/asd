package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanhak.dao.Dao;

public class DeleteMemberCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mid = (String)request.getParameter("id");
		
		Dao dao = new Dao();
		dao.deleteMember(mid);
		
	}

}

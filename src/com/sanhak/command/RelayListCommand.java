package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;

public class RelayListCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Dao dao = new Dao();
		HttpSession session = request.getSession();
		session.setAttribute("RelayList", dao.getRelayList());
		
	}

	
	
}

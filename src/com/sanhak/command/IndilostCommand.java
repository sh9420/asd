package com.sanhak.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.indilostitemDto;

public class IndilostCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int inum = Integer.parseInt(request.getParameter("inum"));
		
		indilostitemDto dto = new indilostitemDto();
		
		Dao dao = new Dao();
		dto = dao.indilostiteminfo(inum);
		HttpSession session = request.getSession();
		session.setAttribute("iteminfo", dto);
	}

}

package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.getitemDto;

public class RelayCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int lostid = Integer.parseInt(request.getParameter("lostid"));
		String mid = request.getParameter("mid");
		String getdate =request.getParameter("getdate");
		
		getitemDto dto = new getitemDto();
		dto.setLostid(lostid);
		dto.setMid(mid);
		dto.setGetdate(getdate);
		
		Dao dao =new Dao();
		dto.setRresult(dao.RelayLostitem(dto));
		HttpSession session = request.getSession();
		session.setAttribute("Relayresult", dto);
	}

	
}

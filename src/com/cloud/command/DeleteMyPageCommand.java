package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class DeleteMyPageCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String mid = request.getParameter("mid");
		
		Dao dao = new Dao();
		memberDto dto = new memberDto();
		int Dresult =dao.deleteMypage(mid);
		
		System.out.println("aaaa="+Dresult);
		dto.setResult(Dresult);
		HttpSession session = request.getSession();
		session.setAttribute("Dresult", dto);
	}

	
}

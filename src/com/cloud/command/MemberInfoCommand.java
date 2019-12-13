package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.memberDto;

public class MemberInfoCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String mid = request.getParameter("id");
		
		memberDto dto = new memberDto();
		
		Dao dao = new Dao();
		dto = dao.updateMember(mid);
		HttpSession session = request.getSession();
		session.setAttribute("mIresult", dto);
	}


}

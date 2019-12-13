package com.sanhak.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.indiReplyDto;

public class ViewIndireplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		 Dao dao = new Dao();
		 HttpSession session = request.getSession();
		 ArrayList<indiReplyDto> dtos ;
		 String inum = request.getParameter("inum");
		 dtos = dao.viewIndiReply(inum);
		 session.setAttribute("RepResult", dtos);
	}
}

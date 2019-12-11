package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanhak.dao.Dao;

public class DeleteIndiReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getParameter("reid"));
		int reid = Integer.parseInt(request.getParameter("reid"));
		int inum = Integer.parseInt(request.getParameter("inum"));
		System.out.println(inum);
		
		Dao dao = new Dao();
		dao.deleteIndireply(reid);
		
	}

}

package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanhak.dao.Dao;

public class DeleteIndilostCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int inum = Integer.parseInt(request.getParameter("inum"));
		
		Dao dao = new Dao();
		dao.deleteIndilostItem(inum);
	}

}

package com.sanhak.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.indilostitemDto;

public class BoardCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		Dao dao = new Dao();
		ArrayList<indilostitemDto> dtos = dao.list();
		HttpSession session = request.getSession();
		session.setAttribute("list",dtos);
	}

}

package com.sanhak.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.commonDto;


public class MainCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
	
		//commonDto comDto = new commonDto();
		Dao dao = new Dao();
		HttpSession session = request.getSession();
		session.setAttribute("orglist", dao.getOrg());
		session.setAttribute("prdtlist", dao.getPrdt());
			
	}
	
	

}

package com.sanhak.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.commonDto;

public class GetCommonCodeCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
/*
		HttpSession session = request.getSession();
		session.setAttribute("mIresult", dto);
*/	
		ArrayList<commonDto> dtos = new ArrayList<commonDto>();
		Dao dao = new Dao();
		dtos = dao.getCommonCode();
		HttpSession session = request.getSession();
		session.setAttribute("cResult", dtos );
	}

}

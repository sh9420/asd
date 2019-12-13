package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sanhak.dao.Dao;
import com.sanhak.dto.indiReplyDto;


public class InsertIndiReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String mid = request.getParameter("mid");
		System.out.println("mid is :"+mid);
		
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(new java.util.Date());
		String redate = today;
		System.out.println("today is : " +today);
		
		String inum =  (String) request.getParameter("inum");
		System.out.println("inum is : "+inum);
		
		String reply = (String) request.getParameter("reply");
		System.out.println("reply is : "+reply);
		
		indiReplyDto dto = new indiReplyDto();
		dto.setInum(inum);
		dto.setMid(mid);
		dto.setRedate(redate);
		dto.setReply(reply);
		
		Dao dao = new Dao();
		dao.insertIndiReply(dto);
		
	}

}

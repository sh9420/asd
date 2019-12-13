package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanhak.dao.Dao;
import com.sanhak.dto.indiReplyDto;

public class UpdateIndiReplyCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = formatter.format(new java.util.Date());
		
		String reid = request.getParameter("reid");
		String redate = today;
		String reply = request.getParameter("reply");
		
		System.out.println("reid : "+reid);
		System.out.println("redate : "+redate);
		System.out.println("reply : "+reply);
		
		indiReplyDto dto = new indiReplyDto();
		
		dto.setRedate(redate);
		dto.setReid(reid);
		dto.setReply(reply);
		
		Dao dao = new Dao();
		dao.updateIndireply(dto);
	}

}

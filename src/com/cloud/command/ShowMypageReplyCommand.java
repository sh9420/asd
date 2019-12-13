package com.sanhak.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.indiReplyDto;

public class ShowMypageReplyCommand implements Command{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      String mid = request.getParameter("mid");
       
      Dao dao = new Dao();
       ArrayList<indiReplyDto> ssdto = dao.showReply(mid);
       HttpSession session = request.getSession();
       session.setAttribute("showReply", ssdto);
   }

}
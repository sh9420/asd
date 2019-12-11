package com.sanhak.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.indilostitemDto;

public class GetMyPageBoardCommand implements Command{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
        
      String mid = request.getParameter("mid");
         
         Dao dao = new Dao();
         ArrayList<indilostitemDto> ssdto = dao.showTitle(mid);
         HttpSession session = request.getSession();
         session.setAttribute("showTitle", ssdto);   
   }

}
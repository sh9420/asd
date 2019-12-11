package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;

public class showLostitemCommand implements Command{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      int lostid = Integer.parseInt(request.getParameter("lostid"));
      
      Dao dao = new Dao();
      
      HttpSession session = request.getSession();
      session.setAttribute("showLostitem", dao.showLostItem(lostid));
      session.setAttribute("prdtlist", dao.getPrdt());
      session.setAttribute("orglist", dao.getOrg());
   }

   
}
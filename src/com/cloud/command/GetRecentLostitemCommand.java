package com.sanhak.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.LostitemDto;
import com.sanhak.dto.commonDto;

public class GetRecentLostitemCommand implements Command{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      System.out.println("getRecentLostitemCommand");
      Dao dao = new Dao();
      HttpSession session = request.getSession();
      session.setAttribute("RLitem", dao.getRecentLostitemCommand_8_KMJ());
      
   
   }

}
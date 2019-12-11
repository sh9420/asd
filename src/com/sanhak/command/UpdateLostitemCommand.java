package com.sanhak.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.dao.Dao;
import com.sanhak.dto.LostitemDto;

public class UpdateLostitemCommand implements Command{

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
   
   
      int lostid = Integer.parseInt(request.getParameter("lostid"));
      int hor = Integer.parseInt(request.getParameter("hor"));
      String prdtname = request.getParameter("prdtname");
      String location = request.getParameter("location");
      String place = request.getParameter("place");
      String sector = request.getParameter("sector");
      String content = request.getParameter("content");
      String status = request.getParameter("status");
      String lstymd= request.getParameter("lstymd");
      String prdtid= request.getParameter("prdtid");
      String orgid = request.getParameter("orgid");
    
      System.out.println(prdtid);
      System.out.println("여기는 lostitem update");
      LostitemDto dto = new LostitemDto();
      
      dto.setPrdtname(prdtname);
      dto.setLostId(lostid);
      dto.setHor(hor);
      dto.setLocation(location);
      dto.setPlace(place);
      dto.setSector(sector);
      dto.setContent(content);
      dto.setStatus(status);
      dto.setLstymd(lstymd);
      dto.setPrdtid(prdtid);
      dto.setOrgid(orgid);
      
      
      System.out.println("dto hor :"+dto.getHor());
      Dao dao = new Dao();
      dao.updateLostItem(dto);
   
  	HttpSession session = request.getSession();
	session.setAttribute("lostitem", dto);
      
   }

   
}
   

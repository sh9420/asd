package com.sanhak.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanhak.command.BoardCommand;
import com.sanhak.command.Command;
import com.sanhak.command.DeleteIndiReplyCommand;
import com.sanhak.command.DeleteIndilostCommand;
import com.sanhak.command.DeleteMemberCommand;
import com.sanhak.command.DeleteMyPageCommand;
import com.sanhak.command.GetCommonCodeCommand;
import com.sanhak.command.GetMyPageBoardCommand;
import com.sanhak.command.GetRecentLostitemCommand;
import com.sanhak.command.IndilostCommand;
import com.sanhak.command.InsertIndiReplyCommand;
import com.sanhak.command.InsertLostitemCommand;
import com.sanhak.command.LoginCommand;
import com.sanhak.command.MainCommand;
import com.sanhak.command.MemberInfoCommand;
import com.sanhak.command.MyPageCommand;
import com.sanhak.command.MyPageUpdateCommand;
import com.sanhak.command.RelayCommand;
import com.sanhak.command.RelayListCommand;
import com.sanhak.command.SearchCommand;
import com.sanhak.command.ShowMypageReplyCommand;
import com.sanhak.command.SignUpCommand;
import com.sanhak.command.UpdateIndiReplyCommand;
import com.sanhak.command.UpdateIndilostitemCommand;
import com.sanhak.command.UpdateLostitemCommand;
import com.sanhak.command.UpdateMemberCommand;
import com.sanhak.command.VeiwMemberCommand;
import com.sanhak.command.ViewIndireplyCommand;
import com.sanhak.command.indilostupdate;
import com.sanhak.command.showLostitemCommand;
import com.sanhak.dto.LostitemDto;

/**
 * Servlet implementation class FrontControl
 */
//@WebServlet("/FrontControl")
public class FrontControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String subPath = request.getRequestURI().substring(request.getContextPath().length());
		String viewName =null;
		Command command =null;
		System.out.println(subPath);
		if(subPath.equals("/login.do")){
			command = new LoginCommand();
			command.execute(request, response);
			viewName = "LoginCheck.jsp";
		}
		else if(subPath.equals("/join.do")){
			command = new SignUpCommand();
			command.execute(request, response);
			viewName = "SignupCheck.jsp";
			
		}
		else if(subPath.equals("/main.do")){
			command = new MainCommand();
			command.execute(request, response);
			command = new GetRecentLostitemCommand();
	        command.execute(request, response);
			viewName = "main.jsp";
		}
		else if(subPath.equals("/search.do")){
			command = new SearchCommand();
			command.execute(request, response);
			viewName = "searchresult.jsp";
		}
		else if(subPath.equals("/mypage.do")) {
	         command = new MyPageCommand();
	         command.execute(request, response);
	         command = new GetMyPageBoardCommand();
	         command.execute(request, response);
	         command = new ShowMypageReplyCommand();
	         command.execute(request, response);
	         viewName = "mypage.jsp";
	      }
		else if(subPath.equals("/MyPageUpdate.do")) {
			command = new MyPageUpdateCommand();
			command.execute(request, response);
			viewName = "mypage.do";
		}
		else if(subPath.equals("/deleteMypage.do")) {
			command = new DeleteMyPageCommand();
			command.execute(request, response);
			viewName = "deletemember.jsp";
		}else if(subPath.equals("/viewMember.do")) {
			command = new VeiwMemberCommand();
			command.execute(request, response);
			viewName = "MemberList.jsp";
		}else if(subPath.equals("/MemberInfo.do")) {
			command = new MemberInfoCommand();
			command.execute(request, response);
			viewName = "MemberInfo.jsp";
		}else if(subPath.equals("/updateMember.do")) {
			command = new UpdateMemberCommand();
			command.execute(request, response);
			viewName = "/viewMember.do";
		}else if(subPath.equals("/deleteMember.do")) {
			command = new DeleteMemberCommand();
			command.execute(request, response);
			viewName = "/viewMember.do";
		}else if(subPath.equals("/showLostitem.do")) {
	         command = new showLostitemCommand();
	         command.execute(request, response);
	         viewName = "/LostItemInfo.jsp";
	    }else if(subPath.equals("/UpdateLostitemview.do")) {
	         command = new showLostitemCommand();
	         command.execute(request, response);
	         viewName = "/UpdateLostitem.jsp";
	     }else if(subPath.equals("/LostitemUpdate.do")) {
	    	 //System.out.println("aaaaupdate");
	         command = new UpdateLostitemCommand();
	         command.execute(request, response);
	         HttpSession session = request.getSession();
	         LostitemDto dto = (LostitemDto)session.getAttribute("lostitem");
	         System.out.println("lostid is "+dto.getLostId()); 
	         viewName = "/showLostitem.do?lostid="+dto.getLostId();
	         
	      }else if(subPath.equals("/relay.do")) {
		        command = new showLostitemCommand();
		         command.execute(request, response);
		         viewName = "/relay.jsp";
	      }else if(subPath.equals("/insertrelay.do")) {
		        command = new RelayCommand();
		         command.execute(request, response);
		         viewName = "/RelayOk.jsp";
	      }else if(subPath.equals("/Board.do")) {
				command = new BoardCommand();
				command.execute(request, response);
				viewName = "Board.jsp";
			}
			else if(subPath.equals("/Indilost.do")) {
				command = new IndilostCommand();
				command.execute(request, response);
				command = new ViewIndireplyCommand();//indireplyCommand
		        command.execute(request, response); 
				viewName = "IndilostItem.jsp";
			}
			else if(subPath.equals("/updateindilostitem.do")) {
				command = new UpdateIndilostitemCommand();
				command.execute(request, response);
				viewName = "/viewIndilostitem.do";
			}
			else if(subPath.equals("/viewIndilostitem.do")) {
				command = new indilostupdate();
				command.execute(request, response);
				viewName = "Board.jsp";
			}
			else if(subPath.equals("/DeleteIndilostitem.do")) {
				command = new DeleteIndilostCommand();
				command.execute(request, response);
				viewName = "/viewIndilostitem.do";
			}else if(subPath.equals("/viewInsertLostitem.do")) {
				command = new GetCommonCodeCommand();
				command.execute(request, response);
				viewName = "/InsertLostitem.jsp";
			}else if(subPath.equals("/insertLostitem.do")) {
				command = new InsertLostitemCommand();
				command.execute(request, response);
				viewName = "/Board.do";
			}else if(subPath.equals("/InsertIndiReply.do")) {
				command = new InsertIndiReplyCommand();
				command.execute(request, response);//insertCommand
				viewName = "/Indilost.do";
			}else if(subPath.equals("/ViewUpdateIndiReplyForm.do")) {
				viewName = "UpdateindiReply.jsp";
			}else if(subPath.equals("/UpdateIndiReply.do")) {
				command = new UpdateIndiReplyCommand();
				command.execute(request, response);//updateCommand
				viewName = "/Indilost.do";
			}else if(subPath.equals("/DeleteIndiReply.do")) {
				command = new DeleteIndiReplyCommand();
				command.execute(request, response);//updateCommand
				viewName = "/Indilost.do";
			}
			else if(subPath.equals("/relayList.do")) {
				command = new RelayListCommand();
				command.execute(request, response);//updateCommand
				viewName = "/relayList.jsp";
			}
		RequestDispatcher view = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}

}

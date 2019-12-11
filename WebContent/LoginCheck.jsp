<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sanhak.dto.*" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	memberDto dto = (memberDto)session.getAttribute("Lresult");
	int result = dto.getResult();
	String id = dto.getMid();
	int grant = dto.getMgrant();
	
	System.out.println("id="+id+"grant="+grant);
	if(result ==1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'main.do'");
		script.println("</script>");
	}else if(result ==0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()");
		script.println("</script>");
	}else if(result ==-1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디입니다.')");
		script.println("history.back()");
		script.println("</script>");
	}else if(result ==-2){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('DB오류가 발생 했습니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	%>

</body>
</html>
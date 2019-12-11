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
	memberDto dto = (memberDto)session.getAttribute("Dresult");
	int result = dto.getResult();
	
	
	if(result ==1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('회원 탈퇴 되었습니다.')");
		script.println("location.href = 'login.jsp'");
		script.println("</script>");
	}else if(result ==-1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('DB오류가 발생 했습니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
	%>

</body>
</html>
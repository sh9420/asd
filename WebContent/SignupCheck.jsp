<%@page import="com.sanhak.dto.memberDto"%>
<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.sanhak.dao.*" %>

<%
	memberDto dto =(memberDto)session.getAttribute("result");
	int result= dto.getResult();
%>

<% 
if (result==2){
%>
<script language="javascript">
	alert("중복된 아이디가 존재합니다.");
	document.location.href="login.jsp";
</script>
<%
}else if(result==-1){
%>
<script language="javascript">
	alert("회원가입에 실패하였습니다.");
document.location.href="login.jsp";
</script>
<%
	}else{
%>
<script language="javascript">
    		alert("회원가입을 축하합니다.");
    		document.location.href="login.jsp";
 </script>
<%	
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=result %>
</body>
</html>


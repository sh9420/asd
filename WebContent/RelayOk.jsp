<%@page import="com.sanhak.dto.getitemDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	
getitemDto gdto =(getitemDto)session.getAttribute("Relayresult");
int result= gdto.getRresult();

%>
<% 
if (result==2){
%>
<script language="javascript">
	alert("전달처리가 완료되었습니다.");
	document.location.href="searchresult.jsp";
</script>
<%
}else if(result==-1){
%>
<script language="javascript">
	alert("날짜를 입력하지 않았거나 전달할 회원의 아이디가 존재하지 않습니다.");
	history.back();
</script>
<%
	}
%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sanhak.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="iso-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">

<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.5/slick.min.css'>

      
      <link rel="stylesheet" href="css/multiple-image-style.css"> 
      <link rel="stylesheet" href="css/form_style.css">
      <link rel="stylesheet" href="css/main_style.css">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.mySlides {display:none}
</style>
</head>
<body>
<header id="header" class="clear">
<%
   memberDto dto = (memberDto)session.getAttribute("Lresult");



%>
    <div id="hgroup">
      <h1><a href="./main.do">Find LostItem</a></h1>
      <h2>Design by 승훈,치헌</h2>
    </div>
    <nav>
      <ul>
       
        <li><a href="./Board.do">Board</a></li>
       <li><a href="./LogOut.jsp">LogOut</a></li>
      </ul>
    </nav>
  </header>
  
</body>
</html>
<script>

	function Logout(){
		location.href="./LogOut.jsp";
		
	}
</script>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- minjung's coding -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- minjung's coding -->
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Homepage test</title>
      <link rel="stylesheet" href="css/input_lostitem_form_style.css">

  <%
  	String mid = request.getParameter("mid");
  	String reply = request.getParameter("reply");
  	String reid = request.getParameter("reid");
  	String inum = request.getParameter("inum");
  %>
</head>
<body>

<div class="wrapper row1">
   <jsp:include page="./headder.jsp"/>  
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container" class="clear">
    <!-- Slider -->
  
    <!-- main content -->
    <div id="homepage">
      <!-- Services -->

			<div class="container">
  
  <div class="row body">
    <form action="./UpdateIndiReply.do?reid=<%=reid %>&inum=<%=inum %>" method="post">
    
      <ul>

        <li>
          <label for="title">작성자</label>
           <%=mid %>
        </li>
               <li><div class="divider"></div></li>
        <li>
       
        <li>
          <label for="iunique">내용</label>
          <textarea cols="46" rows="3" name="reply"><%=reply %></textarea>
        </li>
        
        <li>
          <input class="btn btn-submit" type="submit" value="댓글수정"/>
          <small>or press <strong>enter</strong></small>
        </li>
        
      </ul>
    </form>  
  </div>
  
  
  
</div>

		</div><!--end homepage  -->
    </div><!--  -->
    <!-- / content body -->
  </div>

</body>
</html>
   

  


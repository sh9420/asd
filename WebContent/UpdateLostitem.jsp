<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.sanhak.dto.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>

   <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css'>

      <link rel="stylesheet" href="css/lostitem_info_style.css">

<body>
<%
   LostitemDto dto = (LostitemDto)session.getAttribute("showLostitem");
   String statnum=dto.getStatus();
   String status="";
   System.out.println(statnum);
   if(statnum.equals("1")){
       status="보관"; 
   }else if(statnum.equals("2")){
       status="전달"; 
   }
   
%>
<div class="wrapper row1">
  <jsp:include page="./headder.jsp"/>
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container" class="clear">
    <!-- Slider -->
  
    <!-- main content -->
    <div id="homepage">
    

    <p style="margin-left:30px">분실물 상세 정보 <p>
     
  <div class="container">
  <div class="row">
    <div class="col-4">
      <img src="http://via.placeholder.com/350x350" alt="Image" width="100%" height="100%">
    </div>
    <div class="col-8">
    <form action="./LostitemUpdate.do?lostid=<%=dto.getLostId() %>" method="post">
      <p>분실물 명 - <input type="text" value="<%=dto.getPrdtname()%>" name="prdtname"> 
      <input type="hidden" name="lostid" value="<%=dto.getLostId()%>">
      <p>관리번호 - <%=dto.getLostId()%></p>
      <p>습득 시간 - <input type="text" value="<%=dto.getHor()%>" name ="hor"></p>
      <p>분실 지역(시) - <input type="text" value="<%=dto.getLocation()%>" name="location"></p>
      <p>분실 장소(군구) - <input type="text" value="<%=dto.getPlace()%>" name="place"></p>
      <p>분실 세부장소 - <input type="text" value="<%=dto.getSector()%>" name="sector"></p>
      <p>특이 사항 - <input type="text" value="<%=dto.getContent()%>" name="content"></p>
      <p>분실물 상태 - <%=status %></p>
                  <input type="hidden" value="<%=statnum%>" name="status">
      <p>습득 일자 - <input type="date" value="<%=dto.getLstymd()%>" name="lstymd"></p>
      <p>분류 -  
                      
                        <select name ="prdtid">
                           <c:forEach var="dto" items="${prdtlist}" varStatus="status">
                              <option value="${dto.code}">${dto.name}</option>
                           </c:forEach>
                        </select></p>    
      <p>보관 기관 -      
      				<select style="width: 150px" name="orgid">
                        	<c:forEach var="dto" items="${orglist}" varStatus="status">
                        		<option value="${dto.code}">${dto.name}</option>
                        	</c:forEach>
                        </select>            
                         
   			<div class="offset-4 col-8">
      			<button style="width: 20%; height: 100%; margin-left:200px;" type="submit" class="btn btn-primary" >완료</button>
    		</div>
    
    </form>
    
    		</div>
      </div>
</div>
 
    
    
</div>
    </div>
    <!-- / content body -->
  </div>

</body>
</html>
   
  



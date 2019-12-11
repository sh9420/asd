<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.sanhak.dto.*" %>
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
      <img src="<%=dto.getPathImg() %>" alt="Image" width="100%" height="100%">
    </div>
    <div class="col-8">
      <h3>분실물 명  - <%=dto.getPrdtname() %></h3>
      <p>관리번호 - <%=dto.getLostId()%></p>
      <p>습득 시간 - <%=dto.getHor()%></p>
      <p>분실 지역(시) - <%=dto.getLocation()%></p>
      <p>분실 장소(군구) - <%=dto.getPlace()%></p>
      <p>분실 세부장소 - <%=dto.getSector()%></p>
      <p>특이 사항 - <%=dto.getContent()%></p>
      <p>분실물 상태 - <%=status%></p>
      <p>습득 일자 - <%=dto.getLstymd()%></p>
      <p>분류 -  <%=dto.getPrdtid() %></p>
      <p>기관명 - <%=dto.getOrgid() %></p>
      <p>기관전화번호 -<%=dto.getEtc() %></p>
    </div>
<%
   memberDto mdto = (memberDto)session.getAttribute("Lresult");

   if(mdto.getMgrant()==2){
%>
    <div class="offset-4 col-8">
      <input onclick="location.href='./UpdateLostitemview.do?lostid=<%=dto.getLostId() %>'" style="width: 10%; margin-left:300px;" type="button" class="btn btn-primary" value="수정"/>
      <input onclick="location.href='./relay.do?lostid=<%=dto.getLostId() %>'" style="width: 10%" type="button" class="btn btn-primary" value="전달"/><br>
 <%} %>
    </div>
  </div>
</div>
 
    
    
</div>
    </div>
    <!-- / content body -->
  </div>

</body>
</html>
   
  



<%@page import="com.sanhak.dto.LostitemDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

<head>
<title>게시판</title>
<style>
	td {font-size : 10pt; width:50px; color : black}
	submit {background:black; color:white;}
	selection {padding: 10px; width: 200px; height: 200px; text-align: justify;}
	footer {background:#333333;}
	div {margin-left:100px; margin-right:100px;}
</style>
</head>

<body>
<%
	LostitemDto ldto = (LostitemDto)session.getAttribute("showLostitem");
String statnum=ldto.getStatus();
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
  <body topmargin=0 leftmargin=0 text=#464646>
<center>
      
      <div style="border:2px solid; padding:20px;">
    <table>
    <form action="insertrelay.do" method="post"> 
    <tr>
        <td bgcolor=white>&nbsp;
            <tr>
                <td width=60 align=left >전달 물품 ID </td>
              		
                <td align=left >
                   <input type="text" name="lostid" value="<%=ldto.getLostId() %>" readonly>
                </td>
            </tr>
            <tr>
                <td width=60 align=left >전달 회원 ID : </td>
                <td align=left >
                   
                    <input type="text" size=10 maxlength=10 name="mid">
                </td>
            </tr>
            <tr>
                <td width=60 align=left >전달 날짜 : </td>
                <td align=left >
                    <input type="date" size=10 maxlength=10 name="getdate"> 

                </td>
            </tr>
            

            <tr>
                <td colspan=10 align=center>
                    <input type="submit" value="등록"
                     style="background-color:black; color:white; border: none; border-radius: 5px;
                     width: 50px; height: 30px;float:left; margin-left:120px;">
            </tr>
            </form>
            
            <p style="font-size:12px; color:gray; text-align:center;
            border:2px solid; border-radius: 5px; padding:50px; width:300px; hight:300px;
            float:left;">
			<br/>
            <br/>
            <br/>
            <br/><img/>
            <br/>
            <br/>
            <br/>
            <br/>
            </p>

            <p style="font-size:12px; color:gray; text-align:center;
            align:right; width:300px; hight:300px; float:right;
            margin-right:60px; line-height:2em;">
				분실물 이름 :  <%=ldto.getPrdtname() %><br/>
            	습득일자 : <%=ldto.getLstymd()%><br/>
            	분실지역(시) : <%=ldto.getLocation()%><br/>
            	분실지역(군구) : <%=ldto.getPlace()%><br/>
            	분실세부장소 : <%=ldto.getSector()%><br/>
            	분류 : <%=ldto.getPrdtid() %><br/>
            	특이 사항 : <%=ldto.getContent()%><br/>
            	분실물 상태 :<%=status%><br/>
            	기관 : <%=ldto.getOrgid() %><br/>
            	기관 전화번호: <%=ldto.getEtc() %><br/>
            	습득시간 : <%=ldto.getHor()%><br/>
            	
            	</p>
            	
            	</div>
            	

</td>
</tr>
</center>   
</table>
</body>
 
</html>
   



  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.5/slick.min.js'></script>



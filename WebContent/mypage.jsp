<%@page import="com.sanhak.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Homepage test</title>
  

      <link rel="stylesheet" href="css/main_style.css">
     <link rel="stylesheet" href="css/Mypage.css">
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<style>

</style>
<body>

<% 
   memberDto dto = (memberDto)session.getAttribute("memberinfo");

%>
<div class="wrapper row1">
  <jsp:include page="./headder.jsp"/>
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container" class="clear">
    <!-- Slider -->
  
    <!-- main content -->
    

    
    
  <div class="table-box" style="width:55%; float:left;">
        <div class="top-button-box">
          
        </div>
        <form name="form1" action="MyPageUpdate.do" method="post" >
            <table style="width:100%;color: black";>
                <colgroup>
                    <col width="110">
                    <col width="50%">
                    <col width="30%">
                </colgroup>
                <tbody >
                   <h2>회원정보</h2>
                    <tr height="50">
                        <th>아이디</th>
                      <td>
                        <input type="text" style="width: 74%"  readonly="readonly" value="<%=dto.getMid() %>" name="mid">
                   </td>
                    </tr>

                    <tr height="50">
                        
                        <th>이름</th>
                        <td colspan="6">
                      
                       <input type="text" style="width: 74%" value="<%=dto.getName()%>" name="name">
         
                        </td>
                        
                       
                    </tr>
                    
                     <tr height="50">
                    <th>비밀번호</th>
                       <td colspan="1">
                          <input type="password" style="margin-left: 20px ; width: 74%" name="password" value="<%=dto.getPassword()%>">
                           
                        </td>
                       </tr>
                     
                       <tr height="50">
                    <th>전화번호</th>
                       <td colspan="1">
                          <input type="text" style="width: 74%" name="mtel" value="<%=dto.getMtel()%>">
                           
                        </td>
                       </tr>  
                    <tr height="50">
                        <th>이메일</th>
                        <td colspan="1" >
                   
                            <input type="email" style="margin-left: 20px; width: 74%" value="<%=dto.getEmail()%>" name="email">
                          </td>
                        </tr>
                     <tr>
                            <td align="right"><button type ="submit"  onclick = "return doUpdqte()">수정</button></td>
                            <td><button type="button" onclick="window.location.href='deleteMypage.do?mid=<%=dto.getMid()%>'">회원탈퇴</button></td>
               </tr>   
                  
                </tbody>
            </table>
            </form>
           </div>
           

        <div style="width:40%; float:right;">      
              <table border="1" style="width: 120%;">
                <tbody>
                     <tr>
                        <th valign=top style="line-height:250%;">
                        <h2  style="color:#191919">내가 작성한 글</h2>
                        <c:forEach items="${showTitle}" var="adto">        
                           <p class="serif">
                           <a href="./Indilost.do?inum=${adto.inum}">● ${adto.title} </a>
                              <p>
                        </c:forEach>
                       <c:set var="notitle" value="${showTitle}"/>
                            <c:if test = "${empty notitle}">
                           <p class="serif"> ● </p>
                           <p class="serif"> ● </p>
                           <p class="serif"> ● </p>
                        </c:if>
                        </th>
                      </tr>
                    <tr>
                       <th valign=top style="line-height:250%;">
                       <h2  style="color:#191919">내가 쓴 댓글</h2>
                       <c:forEach items="${showReply}" var="ddto">
                           <p  class="serif"> 
                           <a href="./Indilost.do?inum=${ddto.inum}">● ${ddto.reply} </a>
                              <p>
                        </c:forEach>
                        <c:set var="noreply" value="${showReply}"/>
                            <c:if test = "${empty noreply}">
                           <p class="serif"> ● </p>
                           <p class="serif"> ● </p>
                           <p class="serif"> ● </p>
                        </c:if>
                       </th>
                   </tr>     
                </tbody>
               </table>
</div>


    <!-- / content body -->
  </div>
</div>
</div>
</body>
</html>
<script>
   function doUpdqte(){
   if (confirm("정말 수정하시겠습니까??") == true){    //확인
       document.form.submit();
   }else{   //취소
       return false;
   }
}

</script>
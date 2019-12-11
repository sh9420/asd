<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Homepage test</title>
<style>
  .aboard {
  	padding:8px;
  	text-align: left;
  	border-bottom: 1px solid #ddd;
  }
 </style>
</head>

<body>

  <html lang="en" dir="ltr">
<head>
<title>JEROEN GUNSTER</title>

<!--[if lt IE 9]><script src="scripts/html5shiv.js"></script><![endif]-->
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
	 <div id="wrap">
    <form action="search.do" method="post">
    <div class="table-box">
        <div class="top-button-box">
          
        </div>
            <table >
                <colgroup>
                    <col width="150">
                    <col width="40%">
                    <col width="10%">
                </colgroup>
                <tbody >
                    <tr height="50">
                        <th>종류</th>
                        <td>
                            <select style="width: 100px" name = "prdtid">
                            	<option value="1">전체</option>
                        	<c:forEach var="dto" items="${prdtlist}" varStatus="status">
                        		<option value="${dto.code}">${dto.name}</option>
                        	</c:forEach>
                        </select>
                        </select>
                        </td>
                        <th>분실지역</th>
                        <td>
                           <select name ="location">
                            <option value="1">전체</option>
                            <option value="강원도">강원도</option>
                            <option value="경기도">경기도</option>
                            <option value="부산광역시">부산광역시</option>
                            <option value="서울특별시">서울특별시</option>
                            <option value="울산광역시">울산광역시</option>
                            <option value="인천광역시">인천광역시</option>
                            <option value="충청남도">충청남도</option>
                            
                        </select>
                        </td>
                    </tr>

                    <tr height="50">
                        
                        
                        
                         <th>분실일자</th>
                        <td>
                           <input type="date" name = "lostdate1"> ~ <input type="date" name ="lostdate2">
                        </td>
                         <th>기관명</th>
                        <td colspan="3">
                        <select style="width: 150px" name="orgid">
                        		<option value = "1">전체</option>
                        	<c:forEach var="dto" items="${orglist}" varStatus="status">
                        		<option value="${dto.code}">${dto.name}</option>
                        	</c:forEach>
                        </select>
                    </tr>

                    <tr height="50">
                         <th>분실물 명</th>
                        <td colspan="3">
                       <input type="text" name = "prdtname">
         					 <button type="submit">검색</button>
                        </td>
  						
                           
                       
                    </tr>
                </tbody>
            </table>
            
           </div>
        </form>
</div>

</div>
<br><br>
<br><br><br><br>     <br>
     <br>
     <br>

  </div>
</div>
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container" class="clear">
  
    <!-- main content -->
    <div id="homepage">
    <table>
    
                <colgroup>
                    <col width="1%"></t>
                    <col width="14%">
                    <col width="5%">
                    <col width="5%">
                    <col width="5%">
                </colgroup>
                <tbody>
                    <tr height="50">
                        <th class="aboard">순번</th>
                        <th class="aboard">분실물 명</th>
                        <th class="aboard">분실지역</th>
                        <th class="aboard">보관기관</th>
                        <th class="aboard">분실날짜</th>
                    </tr>
            	<c:forEach var="dto" items="${searchresult}" varStatus="status">
                    <tr height="50">
                    	
                        	<td class="aboard">${status.count} </td>
                        	<td class="aboard" colspan="1"><a href="showLostitem.do?lostid=${dto.lostId} ">${dto.prdtname}</a></td>
                        	<td class="aboard">${dto.location}</td>
                        	<td class="aboard">${dto.coname}</td>
                        	<td class="aboard">${dto.lstymd }</td>
                       
                    </tr>
                  </c:forEach>
            </table>
      <!-- Services -->
    <div id="wrap">
   
    </div>
    </div>
    </div>

</div>
</body>
</html>
   
  

</body>

</html>


<script>

</script>
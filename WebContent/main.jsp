<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Homepage test</title>

  
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
<br><br>
<br><br><br><br>     <br>
     <br>
     <br>
<div class="container">
  <h2>최근 습득한 분실물</h2>
    <div class="row">
      <div class="col-md-12 heroSlider-fixed">
        <div class="overlay">
      </div>
         <!-- Slider -->
               <div class="slider responsive">
       				 <c:forEach var="dto" items="${RLitem}" varStatus="status">                 
                   <div>
                  <a href="showLostitem.do?lostid=${dto.lostId} ">
                  <img src="${dto.pathImg}" alt="" width="200px" height="200px"/>
                  </a><br>
                 	 이름 : ${dto.prdtname}<br>
                  	습득일자 : ${dto.lstymd}<br>
               </div>         
      				</c:forEach>
        		</div>
				 <!-- control arrows -->
				<div class="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				</div>
				<div class="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				</div>
				
      </div>
    </div>
  </div>

</div>
    </div>
    <!-- / content body -->
  </div>
</div>
</div>
</body>
</html>
   
  

</body>

</html>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.5/slick.min.js'></script>

  

    <script  src="js/multiple-image.js"></script>
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-red", "");
  }
  x[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " w3-red";
}
</script>

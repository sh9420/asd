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
  <div class="row header">
    <h2 class="aa">자신의 분실물을 입력하세요! &nbsp;</h2>
    <h3 class="aa">아래 입력창에 분실물에 대한 정보를 입력하세요.</h3>
  </div>
  <div class="row body">
    <form action="./insertLostitem.do" method="post" enctype="multipart/form-data">
    
      <ul>

        <li>
          <label for="title">제목</label>
           <input type="text" name="title" placeholder="제목" size="60" required/>
        </li>
               <li><div class="divider"></div></li>
        <li>
        <li>
          <p>
            <label for="iprdtname">분실품 명</label>
            <input type="text" name="iprdtname" placeholder="분실물 명" required/>
          </p>
          <p class="pull-right">
            <label for="pathImg">물품 사진 등록</label>
            <input type="file" name="pathImg" style="width:300px"/>      
          </p>
        
        </li>
        <li>
          <p>
            <label for="hor">분실 시간</label>
            <input type="text" name="hor" placeholder="ex)13 (24시 기준)" required/>
          </p>
          <p class="pull-right">
            <label for="lstdate">분실 일자</label>
            <input type="date" name="lstdate" style="width:300px" required/>      
          </p>
        </li>
        <li>
          <p>
            <label for="ilocation">분실장소(시)</label>
            <input type="text" name="ilocation" placeholder="ex)부산광역시" required/>
          </p>
          <p class="pull-right">
            <label for="iplace">분실장소(군구)</label>
            <input type="text" name="iplace" placeholder="ex)사상구" style="width:300px" required/>      
          </p>
        </li>
        
         <li>
          <p>
            <label for="isector">분실 세부 장소</label>
            <input type="text" name="isector" placeholder="ex)버스안, 지하철" required/>
          </p>
          
          <p class="pull-right">
            <label for="last_name">분류</label>
            
            <!-- minjung's codimg -->
            <select name="iprdtid" style="width:300px" required>        
            <c:forEach var="dto" items="${cResult}" varStatus="status">
                 <option value ="${dto.code}">${dto.name}</option>
         	</c:forEach>
         	</select>
            <!-- minjung's codimg  -->
            
          </p>
        </li>
        
                
        <li><div class="divider"></div></li>
        <li>
          <label for="iunique">특이사항</label>
          <textarea cols="46" rows="3" name="iunique" required></textarea>
        </li>
        
        <li>
          <input class="btn btn-submit" type="submit" value="등록"/>
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
   

  


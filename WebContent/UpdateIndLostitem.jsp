<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en" >

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
    <h2 class="aa">자신의 분실물을 수정하세요! &nbsp;</h2>
    <h3 class="aa">아래 입력창에 분실물에 대한 정보를 수정하세요.</h3>
  </div>
  <div class="row body">
    <form action = "./updateindilostitem.do?inum=${iteminfo.inum}" method = "post" enctype="multipart/form-data">
      <ul>
           
        <li>
           <p>
              <input type="hidden" name ="istatus" value="1">
            <label for="first_name">게시글 제목</label>
            <input type="text" name="title" placeholder="게시글 제목"  value="${iteminfo.title}"/>
          </p>
         
         
        
        </li>
        <li>
         <p>
            <label for="first_name">분실품 명</label>
            <input type="text" name="iprdtname" placeholder="분실품명"  value="${iteminfo.iprdtname}"/>
         </p>
          <p class="pull-right">
            <label for="last_name">물품 사진 등록</label>
            <input type="file" name="pathImg" style="width:300px" />      
          </p>
        </li>
        <li>
          <p>
            <label for="first_name">분실 시간</label>
            <input type="text" name="hor" placeholder="ex)13 (24시 기준)"  value="${iteminfo.hor}" />
          </p>
          <p class="pull-right">
            <label for="last_name">분실 일자</label>
            <input type="date" name="lstdate" style="width:300px" value="${iteminfo.lstdate}"/>      
          </p>
        </li>
        <li>
          <p>
            <label for="first_name">분실장소(시)</label>
            <input type="text" name="ilocation" placeholder="ex)부산광역시" value="${iteminfo.ilocation}" />
          </p>
          <p class="pull-right">
            <label for="last_name">분실장소(군구)</label>
            <input type="text" name="iplace" placeholder="ex)사상구" style="width:300px" value="${iteminfo.iplace}"/>      
          </p>
        </li>
        
         <li>
          <p>
            <label for="first_name">분실 세부 장소</label>
            <input type="text" name="isector" placeholder="John" value="${iteminfo.isector}"/>
          </p>
          
          <p class="pull-right">
            <label for="last_name">분류</label>
            <select style="width:300px" name= "iprdtid">
               <c:forEach var="dto" items="${prdtlist}" varStatus="status">
                              <option value="${dto.code}">${dto.name}</option>
                 </c:forEach>
            </select>      
          </p>
        </li>
        
                
        <li><div class="divider"></div></li>
        <li>
          <label for="comments">특이사항</label>
          <textarea cols="46" rows="3" name = "iunique">${iteminfo.iunique}</textarea>
        </li>
        
        <li>
          <input class="btn btn-submit" type="submit" value="수정" />
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
   


</html>

  
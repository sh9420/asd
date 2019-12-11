<%@page import="com.sanhak.dto.indilostitemDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Homepage test</title>

   <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta.2/css/bootstrap.css'>

      <link rel="stylesheet" href="css/lostitem_info_style.css">

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
    

    <p style="margin-left:30px">${indidResult.title } <p>
    
  <div class="container">
  <div class="row">
    <div class="col-4">
      <img src="${iteminfo.pathImg }" alt="Image" width="100%" height="100%">
    </div>
    <div class="col-8">
     <input type="hidden" name="inum" value="${iteminfo.inum}" >
     <h3>분실물 : ${iteminfo.iprdtname}</h3>
      <h3>제목 : ${iteminfo.title}</h3>
      <p>ID - ${iteminfo.mid}</p>
      <p>게시 일자 -${iteminfo.postdate}</p>
      <p>분실 지역(시) - ${iteminfo.ilocation}</p>
      <p>분실 장소(군구) - ${iteminfo.iplace}</p>
      <p>분실 세부장소 - ${iteminfo.isector}</p>
      <p>특이 사항 - ${iteminfo.iunique}</p>
      <p>분실 일자 -${iteminfo.lstdate}</p>
      <p>분류 - ${iteminfo.iprdtid}</p>
    </div>
    
	<c:if test="${(Lresult.mid == iteminfo.mid) || Lresult.mgrant == 2}">
    <div class="offset-4 col-8">
      <input style="width: 10%; margin-left:300px;" type="button" class="btn btn-primary" value="수정" onclick="location.href='./UpdateIndLostitem.jsp'"/>
      <input style="width: 10%" type="button" class="btn btn-primary" value="삭제" onclick="location.href='DeleteIndilostitem.do?inum=${iteminfo.inum}'"/><br>
    </div>
    </c:if>
	
    <div>
    <br><br>
    
   	<hr>
   	<c:forEach var="dto" items="${RepResult}" varStatus="status">
   	<form action="ViewUpdateIndiReplyForm.do" method="post">
   		작성자 : ${dto.mid} 등록시간 : ${dto.redate} 
   		<br><br>
   		<input type="hidden" name="inum" value="${iteminfo.inum}">
   		<input type="hidden" name="reid" value="${dto.reid}">
   		<input type ="hidden" name ="mid" value="${dto.mid}">
    	내용 : <textarea name="reply" cols="60" rows="3" readonly="readonly">${dto.reply }</textarea><br>
    	 <c:if test="${(Lresult.mid == dto.mid) || (Lresult.mgrant == 2)}">
    	
    <div class="col-8">
      <input style="margin-left:220px;" type="submit" class="btn btn-primary" onclick = "return doUpdate()" value="수정"/>
      <input type="button" class="btn btn-primary" value="삭제" onclick="location.href='./DeleteIndiReply.do?reid=${dto.reid}&inum=${iteminfo.inum}'"/><br>
    </div>
   </c:if>
    </form>
    	<hr>
    	
   	 </c:forEach>
   	 <form action="./InsertIndiReply.do?inum=${iteminfo.inum }&mid=${Lresult.mid}" method="post">
    	작성자 : ${Lresult.mid}<br><br>
    	내용 : <textarea name="reply" cols="60" rows="3" ></textarea><br>
    	<input type="submit" class="btn btn-submit" value="댓글등록">
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
   
  
<script>
   function doUpdate(){
   if (confirm("정말 수정하시겠습니까??") == true){    //확인
       document.form.submit();
   }else{   //취소
       return false;
   }
}



</script>



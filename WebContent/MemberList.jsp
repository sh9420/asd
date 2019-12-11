<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en" >

<style>

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}
</style>

<body>
<div class="wrapper row1">
  <jsp:include page="./headder.jsp"/>
</div>
<!-- content -->
<div class="wrapper row2">
  <div id="container" class="clear">
     <table >
                <colgroup>
                    <col width="70">
                    <col width = "40%">
                    <col width = "40%">
                    <col width= "70">
                </colgroup>
                <tbody>
                    <tr height="50" style = "color:black; border: 0px, 0px, 0px, 1px";>
                        <th>#번호</th>
                        <th>아이디</th>
                        <th> 이름 </th>
                        <th> 삭제 </th>
                    </tr>
                   
  			 	<c:forEach var="dto" items="${allviewMember}" varStatus="status">
                    <tr height="50">
                        <th>${status.count}. </th>
                        <td colspan="1">
                        <a href="./MemberInfo.do?id=${dto.mid}">${dto.mid}</a> 
                        </td>
                        <td>
                         ${dto.name}
                        </td>
                        <td>
                        <%-- <input type = "button" value = "삭제" onclick="location.href='./deleteMember.do?id=${dto.mid}'"> --%>
                        <input type = "button" value = "삭제" onclick="doDelete('${dto.mid}');">
                         
                        </td>
                    </tr>
         			</c:forEach>
                </tbody>
            </table>
     
    <!-- main content -->
    <div id="homepage">
      <!-- Services -->
    <div id="wrap">
    
</div>

</div><!-- homepage -->
    </div>
    <!-- / content body -->
  </div>
</div>
</div>
</body>
</html>
   


</html>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.5.5/slick.min.js'></script>

  

    <script  src="js/multiple-image.js"></script>
<script>

function doDelete(id){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
		var url;
		url = './deleteMember.do?id=';
		url = url + id
		location.href = url;
	}else{   //취소
	    return;
	}
}
</script>
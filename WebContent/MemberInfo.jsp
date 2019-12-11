<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Homepage test</title>
  
  

      <link rel="stylesheet" href="css/main_style.css">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>

<body>

  <html lang="en" dir="ltr">
<head>
<title>JEROEN GUNSTER</title>
<meta charset="iso-8859-1">
<link rel="stylesheet" href="styles/layout.css" type="text/css">
<!--[if lt IE 9]><script src="scripts/html5shiv.js"></script><![endif]-->
</head>
<body>
<div class="wrapper row1">
  <jsp:include page="./headder.jsp"/>
</div>
<!-- content -->
<div class="wrapper row2">
  <div class="container">
  <br></br>
  <div style="border:1px solid black; height:550px;">
  <form action = "./updateMember.do" method = "post">
  <table align="center" >
    <p align ="center" style="font-size:50px; color: black"> 회원정보 </p>
    <tbody>
      <tr>
        <td style="font-size:30px; color: black; line-height:300%;" align="right">아이디 :</td>
        <td>
          &nbsp;<input type="text" name = "id" style="height:35px; color :black" value = "${mIresult.mid}">
        </td>      
      </tr>
      <tr>
         <td style="font-size:30px; color: black; line-height:300%;" align="right">
      		비밀번호 :
         </td>
         <td>
             &nbsp;<input type="text" name = "password" style="height:35px; color:black" value = "${mIresult.password}">
         </td>       
      </tr>
       <tr>
         <td style="font-size:30px; color: black; line-height:300%;" align="right">
      		이름 :
         </td>
         <td>
             &nbsp;<input type="text" name = "name" style="height:35px; color:black" value = "${mIresult.name}">
         </td>       
      </tr>
      <tr>    
          <td style="font-size:30px; color: black; line-height:300%;" align="right">
         	전화번호 :
          </td>
          <td>
             &nbsp;<input type="text" name = "mtel" style="height:35px; color:black" value = "${mIresult.mtel}">
          </td> 
      </tr>
      <tr>
          <td style="font-size:30px; color: black; line-height:300%;" align="right">
        	이메일 :
          </td>
          <td>
             &nbsp;<input type="text" name = "email" style="height:35px;color :black" value = "${mIresult.email}">
          </td>
      </tr>
    </tbody>
    
  </table>
  <div align="center">
  <button type="submit" class="btn btn-outline-primary" style="width:100px; height:40px;" onclick = "return doUpdqte()">수정</button>
  </div>
  </form>
<br></br>
  </div>
</div>
<br></br>

</div>
</div>
</body>
<script>
function doUpdqte(){
	if (confirm("정말 수정하시겠습니까??") == true){    //확인
	    document.form.submit();
	}else{   //취소
	    return false;
	}
}

</script>
</html>

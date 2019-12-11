<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sanhak.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<style>

th {
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
    <!-- Slider -->
    <!-- main content -->
    <div id="homepage">
    <table>
                <colgroup>
                    <col width="20%">
                    <col width="5%">
                    <col width="5%">
                    <col width="3%">
                </colgroup>
                <tbody>
                    <tr height="50">
                        <th>�Խñ� ��</th>
                        <th>�ۼ���</th>
                        <th>�ۼ���</th>      
                    </tr>
             <c:forEach items="${list}" var="dto">
                    <tr height="50">
                        <th colspan="1">
                        <a href="./Indilost.do?inum=${dto.inum}">${dto.title}</a></th>
                        <th>${dto.mid}</th>
                        <th>${dto.postdate}</th>
                    </tr>
                     </c:forEach>
                    <tr height="50">
                       <td colspan="1"><input type="button" value = "���" onclick = "location.href='viewInsertLostitem.do'"> </td>
                        <td colspan="2">
                        <select>
                     <option value="1">�ۼ���</option>
                        <option value="2">���</option>
                          <option value="3">�з�</option>
                        <option value="4">��¥</option>
                    </select>
                  <input type = "text"><input type = "button" value="�˻�"></td>
                    </tr>       
            </table>
      <!-- Services -->
    <div id="wrap">
    </div>
    </div>
      
    </div>

</div>
</body>
</html>
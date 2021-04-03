<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="member.MemberBean" %>
<%
MemberBean mbean = (MemberBean) request.getAttribute("detail");
%>

 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/atDetail.js"></script>
<!-- <script>
window.onload=function(){
	var selMBtn = document.querySelector('.update');
	var selDBtn = document.querySelector('.delete');
	var selForm = document.querySelector('form');
	console.log(selMBtn)
	selMBtn.onclick=function(){
		selForm.setAttribute("action", "updateMember.me");
		selForm.setAttribute("method", "post");
	}
	selDBtn.onclick=function(){
		selForm.setAttribute("action", "removeMember.me");
		selForm.setAttribute("method", "post");
	}
}
</script> -->
</head>
<body>
<form>
<table>
<tr>
<td colspan="2">상세 정보</td>
</tr>
<tr>
<td>id</td><td><input name="id" type="text" value="<%= mbean.getId() %>"></td>
</tr>
<tr>
<td>pw</td><td><input name="pw" type="password" value="<%= mbean.getPw() %>"></td>
</tr>
<tr>
<td>name</td><td><input name="name" type="text" value="<%= mbean.getName() %>"></td>
</tr>
<tr>
<td>birth</td><td><%= mbean.getBirth() %></td>
</tr>
<tr>
<td>age</td><td><%= mbean.getAge() %></td>
</tr>
<tr>
<td>gender</td><td><%= mbean.getGender() %></td>
</tr>
<tr>
<td>email</td><td><input name="email" type="text" value="<%= mbean.getEmail() %>"></td>
</tr>
<tr>
<%-- 
<tr>
<td>id</td><td><input readonly name="id" type="text" 
value="<%= request.getAttribute("id") %>"></td>
</tr>
<tr>
<td>pw</td><td><input name="pw" type="password" value="<%= request.getAttribute("pw") %>"></td><%= mbean.getPw() %>
</tr>
<tr>
<td>name</td><td><input name="name" type="text" value="<%= request.getAttribute("name") %>"></td>
</tr>
<tr>
<td>birth</td><td><%= request.getAttribute("birth") %></td>
</tr>
<tr>
<td>age</td><td><%= request.getAttribute("age") %></td>
</tr>
<tr>
<td>gender</td><td><%= request.getAttribute("gender") %></td>
</tr>
<tr>
<td>email</td><td><input name="email" type="text" value="<%= request.getAttribute("email") %>"></td>
</tr>
<tr>
 --%>
<td colspan="2"><input type="submit" value="수정" class="update"> <input type="submit" value="삭제" class="delete"></td>
</tr>
</table>
</form>
</body>
</html>
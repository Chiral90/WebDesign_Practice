<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="deleteMember.me" method="post">
<table>
<tr>
<td>id</td><td><input name="id" readonly type="text" value="<%= request.getParameter("id") %>"></td>
</tr>
<tr>
<td>pw</td><td><input name="pw" type="password"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="삭제"></td>
</tr>
</table>
</form>
</body>
</html>
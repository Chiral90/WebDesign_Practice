<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/atSignUp.js"></script>
</head>
<body>
회원가입 페이지
<form action="insertAction.me" method="post">
<table>
<tr>
<td colspan="2">회원 가입</td>
</tr>
<tr>
<td>id</td><td><input type="text" name="id"></td>
</tr>
<tr>
<td>pw</td><td><input type="password" name="pw"></td>
</tr>
<tr>
<td>pw check</td><td><input type="password" name="pwcheck"></td>
</tr>
<tr>
<td>name</td><td><input type="text" name="name"></td>
</tr>
<tr>
<td>birth</td><td><input type="text" name="birth"></td>
</tr>
<tr>
<td>age</td><td><input type="text" name="age"></td>
</tr>
<tr>
<td>gender</td><td><input type="radio" name="gender" value="male">남
<input type="radio" name="gender" value="female">여</td>
</tr>
<tr>
<td>email</td><td><input type="text" name="email"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="가입하기"></td>
</tr>
</table>
</form>
</body>
</html>
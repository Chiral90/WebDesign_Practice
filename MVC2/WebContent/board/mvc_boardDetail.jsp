<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.boardDataBean" %>
<% boardDataBean detail = (boardDataBean) request.getAttribute("detail");
request.setAttribute("no", detail.getNo());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/atBoardDetail.js"></script>
</head>
<body>
<form>
<table>
<tr>
<td>게시판 번호</td><td><%= detail.getNo() %></td><td>조회수 : <%= detail.getView() %></td><td>좋아요 : <%= detail.getLike() %></td>
</tr>
<tr>
<td>제목</td><td><input name="title" type="text" value="<%= detail.getTitle() %>"></td>
<td>작성자</td><td><%= detail.getId() %></td>
</tr>
<tr>
<td>내용</td><td colspan="3"><textarea name="content"><%= detail.getContent() %></textarea></td>
</tr>
<tr>
<td colspan="4"><input class="like" name="like" type="submit" value="like"></td>
</tr>
<tr>
<td colspan="4"><input class="modify" type="submit" value="글 수정"><input class="delete" type="submit" value="글 삭제"></td>
</tr>
</table>
</form>
</body>
</html>
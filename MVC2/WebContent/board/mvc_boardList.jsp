<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page import="board.boardDataBean" %>
<%@ page import="java.util.ArrayList" %>
<% ArrayList<boardDataBean> blist = (ArrayList) request.getAttribute("blist"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>글 번호</td><td>글 제목</td><td>작성자</td><td>조회수</td><td>좋아요</td>
</tr>

<% for (int i=0;i<blist.size();i++) { 
	boardDataBean bbean = blist.get(i);
%>
<tr>
<td><%= bbean.getNo() %></td>
<td><a href="detailBoard.bo?no=<%= bbean.getNo() %>&view=<%= bbean.getView() %>"><%= bbean.getTitle() %></a></td>
<td><%= bbean.getId() %></td>
<td><%= bbean.getView() %></td>
<td><%= bbean.getLike() %></td>
</tr>
<% } %>

</table>

</body>
</html>
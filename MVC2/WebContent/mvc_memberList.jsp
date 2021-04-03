<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="member.MemberBean" %>

<%
//request.getAttribute("mlist"); //: object type --> 따라서 형변환 필요
ArrayList<MemberBean> mlist = (ArrayList) request.getAttribute("mlist");
%>

<% int length = Integer.parseInt(request.getAttribute("length").toString()); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>id</td><td>name</td>
</tr>
<%-- 
<% for (int i=0;i<mlist.size();i++) { 
	MemberBean mdb = (MemberBean) mlist.get(i);
%>
<tr>
<td><%= mdb.getId() %></td>
<td><a href="detailMember.me?id=<%= mdb.getId() %>"><%= mdb.getName() %></a></td>
</tr>
<% } %>
 --%>

<% for (int i=0;i<length;i++) { %>
<tr>
<td><%= request.getAttribute("id"+i) %></td>
<td><a href="detailMember.me?id=<%= request.getAttribute("id"+i) %>">
<%= request.getAttribute("name"+i) %></a></td>
</tr>
<% } %>


</table>
</body>
</html>
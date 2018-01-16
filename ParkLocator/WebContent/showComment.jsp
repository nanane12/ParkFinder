<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.*, parkLookUpJDBC.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>calling list of comments</title>
</head>
<body>
<%
//get the parks from the request object (use attribute name on sevlet)
	List <Comments>theComment=
				(List<Comments>)request.getAttribute("Showing_Comments");

%>

<div id="wrapper">
	<div id="header">
		<h2>This is the comment about the park</h2>
		
	</div>
</div>

<!-- table contents set up -->
<div id="container">
	<div id="content">
		<table class="table table-bordered">
			<tr>
				<th> Comment Number</th>
				<th> Child Age </th>
				<th> Rating</th>
				<th> Comment</th>
				<th> Park Number</th>
			</tr>
			
			<!-- loop through the list of info --> 
			<% for (Comments tempComment : theComment) { %>
			<tr>
				<td> <%= tempComment.getCommentId() %></td>
				<td> <%= tempComment.getChildAge() %></td>
				<td> <%= tempComment.getRating() %></td>
				<td> <%= tempComment.getFreeText() %></td>
				<td> <%= tempComment.getPark_id() %></td>
			</tr>
			<% } %>
		</table>
	</div>
</div>
<p>
<a href="index.html">back to home</a>
</p>
</body>
</html>
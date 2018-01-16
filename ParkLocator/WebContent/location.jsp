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
<title>Calling List of Park</title>
</head>
<body>

<%
//get the parks from the request object (use attribute name on sevlet)
	List <Park>thePark=
				(List<Park>)request.getAttribute("PARK_LIST");

%>

<div id="wrapper">
	<div id="header">
		<h2>This is the park in your area</h2>
		
	</div>
</div>

<!-- table contents set up -->
<div id="container">
	<div id="content">
		<table class="table table-bordered">
			<tr>
				<th> Name of the Park</th>
				<th> Address </th>
				<th> ZipCode </th>
				<th> Web Address</th>
			</tr>
			
			<!-- loop through the list of info --> 
			<% for (Park tempPark : thePark) { %>
			<tr>
				<td> <%= tempPark.getNameOfPark() %></td>
				<td> <%= tempPark.getAddressOfPark() %></td>
				<td> <%= tempPark.getZipCode() %></td>
				<td> <%= tempPark.getWebsite() %></td>
			</tr>
			<% } %>
		</table>
	</div>
</div>

<!-- next section for adding the comment -->
<h4> Would you like to add comment about park?</h4>
<input type="button" value="Add Comment"
	onclick="window.location.href='add-comment-form.jsp';return false;"
	class="btn btn-add-comment-button" 

/>
<h4>OR</h4>

<h4>Would you like to see the comments?</h4>
<input type="button" value="Show Comment"
	onclick="window.location.href='commentRequest.jsp'; return false;"
	class="btn btn-showCommentButton"
	/>
	

</body>
</html>
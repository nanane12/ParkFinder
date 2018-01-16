<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User request for comment listing</title>
</head>
<body>
<form action="AddComment" method="GET">
<h2>Please choose the park for comments. </h2>
<input type="hidden" name="showingComment" value="show"/>
	<select name="parks">
						
	<option value="1">Jefferson Barracks</option>
	<option value="2"> Creve Couer </option>
	<option value="3">Faust Park</option>
	</select>
	
<p>
<input type="submit" name="submit" value="submit"/>
</p>

</form>
</body>
</html>
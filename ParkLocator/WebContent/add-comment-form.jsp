<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add Comment about Park</title>
</head>


<body>
<form action="AddComment" method="POST">
	<div id="wrapper">
		<div id="header">
			<h2>Please fill out the following form</h2>
		</div>
	
	</div>
	<div id="container">
		<h3>Add Comment</h3>
		
		
			<input type="hidden" name="command" value="ADD"/>
			
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><label>Please choose the park</label></td>
						<td><select name="parks">
						
						<option value="1">Jefferson Barracks</option>
						<option value="2"> Creve Couer </option>
						<option value="3">Faust Park</option>
						</select>
						
						</td>
					<tr>
						<td><label> Your Child's Age if any:</label></td>
						<td><input type="number" name="ChildAge" min="0" max="21"/></td>
					</tr>
					
					<tr>
						<td><label> Rating: 1-5 (poor-excellent)</lablel></td>
						<td><input type="number" name="rating" min="1" max="5"/></td>
					</tr>	
					<tr>
						<td><label>Any Comments about the park</label>
						<td><textarea name="freeText" cols="50" rows="10"></textarea></td>
					</tr>
				
				</tbody>
			
			</table>
	
	</div>
<input type="submit" value="save"/>
</form>
</body>
</html>
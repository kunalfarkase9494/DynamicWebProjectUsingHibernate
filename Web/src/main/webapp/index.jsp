<%@page import="java.util.List"%>
<%@page import="com.Model.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container d-flex">
<div class="container my-4">
<h2 class="text-center">Add Employee</h2>
<br>
<form action="add" class="text-center">
<table class="table border table-success">
<tr>
	<td>Enter ID :-</td>
	<td><input type="text" name="uid" class="form-control"></td>
</tr>
<tr>
	<td>Enter Name :-</td>
	<td><input type="text" name="uname" class="form-control"></td>
</tr>
<tr>	
	<td>Enter Salary :-</td>
	<td><input type="text" name="usalary" class="form-control"></td>
</tr>
<tr>
<td></td>
<td><button class="btn btn-success">Add</button></td>
</tr>
</table>
</form>
</div>

<div class="container my-4">
<h2 class="text-center">Update Employee</h2>
<br>
<form action="update" class="text-center">
<table  class="table border table-primary">
<tr>
	<td>Enter ID :-</td>
	<td><input type="text" name="uid" class="form-control"></td>
</tr>
<tr>
	<td>Enter new Name :-</td>
	<td><input type="text" name="uname" class="form-control"></td>
</tr>
<tr>	
	<td>Enter new Salary :-</td>
	<td><input type="text" name="usalary" class="form-control"></td>
</tr>
<tr>
<td></td>
<td><button class="btn btn-info">Update</button></td>
</tr>
</table>
</form>
</div>


<div class="container my-4">
<h2 class="text-center">Delete Employee</h2>
<br>
<form action="delete" class="text-center">
<table  class="table border table-danger">
<tr>
	<td>Enter ID :-</td>
	<td><input type="text" name="uid" class="form-control"></td>
</tr>
<tr>
	<td></td>
	<td><button class="btn btn-danger">Delete</button></td>
</tr>
</table>
</form>
</div>
</div>

<div class="container w-75 my-3">
<form action="read">
<input type="hidden" name="count" value="0">
<button class="btn btn-primary">read</button>
</form>
<br>
<table class="table table-striped table-light">
<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Salary</th>
</tr>

<% 
List<Employee> l = (List<Employee>)session.getAttribute("al");
String getc = (String)session.getAttribute("c");
int count = 0;
if(l!=null){
	for(Employee e:l){
		count++;
%>		
	<tr>
		<td><%=e.getId() %></td>
		<td><%=e.getName() %></td>
		<td><%=e.getSalary() %></td>
	</tr>	
<%		
	}
}
%>
</table>
<br>
<form action="read">
<input type="hidden" name="count" value="<%=count%>">
<button class="btn btn-secondary">Next</button>
</form>
</div>
</body>
</html>
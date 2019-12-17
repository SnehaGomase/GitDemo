<%@page import="com.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Success page</title>
<script type="text/javascript">
function deletedata() 
{
    alert("Delating Data-----");
	document.myform.action="delet";
	
	document.myform.submit();
}
function updatedata()
{
	alert("Updating Data---");
	document.myform.action="update";
	document.myform.submit();
}
function adddata()
{
	alert("Adding Data---");
	document.myform.action="register.jsp";
	document.myform.submit();
}

</script>
</head>
<body style="background-color: yellow">
<form name="myform">
<h1 style="color: blue">Successfully Done!!!</h1>
<h2 style="color: orange">Data In Table Format</h2>
<table border="3x">
<tr>
<td> reid </td>
<td> ename </td>
<td> eaddr </td>
<td> username</td>
<td> password</td>
</tr>
<tr>
<%List<Employee>emp1=(List)request.getAttribute("LIST");
for(Employee emp:emp1)
{%>
<td><input type="radio" name="reid" value="<%=emp.getReid()%>"></td>
<td><%=emp.getEname()%></td>
<td><%=emp.getEaddr()%></td>
<td><%=emp.getUsername()%></td>
<td><%=emp.getPassword()%></td>
</tr>
<%}%>
<tr>
<td><input type="button" value="DELET"  onclick="deletedata()"></td>
<td><input type="button" value="UPDATE" onclick="updatedata()"></td> 
<td><input type="button" value="ADD" onclick="adddata()"></td>
</tr>
</table>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Update Page</title>
</head>
<body>
<form action="update1">
<h1>Update Page</h1>
<h3>Enter The Information To Be Updated</h3>
<input type="hidden" name="reid" value="${EE.reid}"><br>
ENAME   :<input type="text" name="ename" value="${EE.ename}"><br> 
EADDR   :<input type="text" name="eaddr" value="${EE.eaddr}"><br>
USERNAME:<input type="text" name="username" value="${EE.username}"><br>
PASSWORD:<input type="text" name="password" value="${EE.password}"><br>
<input type="submit" value="UPDATE">

</form>
</body>
</html>
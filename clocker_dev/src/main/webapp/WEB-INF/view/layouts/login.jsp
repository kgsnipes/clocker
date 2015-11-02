<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	
	
	Login page
<form action="login-validate" method="POST">
  <table>
<tbody><tr>
    <td>Username:</td>
    <td><input name="j_username" type="text"></td>
   </tr>
<tr>
    <td>Password:</td>
    <td><input name="j_password" type="password"></td>
   </tr>
<tr>
    <td colspan="2"> </td>
   </tr>
<tr>
    <td colspan="5"><input name="submit" type="submit" value="Go"> <input name="reset" type="reset"></td>
   </tr>
</tbody></table>
</form>


</body>
</html>

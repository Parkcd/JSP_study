<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿</title>
<script type="text/javascript" src="./js/param.js"></script>

</head>
<body>
	<form method="get" action="ParamServlet" name="frm">
	ID :   <input type="text" name="id"><br>
	AGE :   <input type="text" name="age"><br>
	<input type="submit" value="전송" onClick="return check()">
	</form>
</body>
</html>
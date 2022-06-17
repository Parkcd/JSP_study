<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eddition_MVC2</title>
</head>
<body>
	Working with server: 

<%=application.getServerInfo() %> <br>

 

Servlet Specification: 

<%=application.getMajorVersion()%>.<%= application.getMinorVersion() %> <br>

 

JSP version: 

<%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %> <br>

	${num1} + ${num2} = ${add}
</body>
</html>
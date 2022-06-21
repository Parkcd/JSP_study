<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP 페이지에서 에러가 발생하였을 때 보여줄 에러 페이지로 error.jsp를 설정 --%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>

<div class="myalign">
<h1>다음과 같은 에러가 발생하였습니다.</h1><br>
<img src="./img/dog.jpg"><br>
</div>
<%= exception.getMessage() %>
</body>
</html>
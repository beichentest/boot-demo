<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
<link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
  
        <h1>Error Handler</h1>
		<div>url : ${url}</div>
		<div>message : ${exception}</div>  
</body>
</html>
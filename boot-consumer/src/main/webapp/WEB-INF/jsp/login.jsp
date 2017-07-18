<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Security Example </title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post">
    <font color="red">  
        <c:if test="${param.error}">  
           <div>login failed,try again!</div>  
           <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">  
                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>  
           </c:if>  
        </c:if>
        <c:if test="${param.logout}">  
           <div> 您已注销成功!</div>          
        </c:if>  
        </font>
    <div><label> 用户名 : <input type="text" name="username"/> </label></div>
    <div><label> 密 码 : <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="登录"/></div>
</form>
</body>
</html>
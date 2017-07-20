<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<body>
<div style="text-alien:right;width:500px">
欢迎
<sec:authentication property="name"/>
<a href="logout.jsp">退出系统</a>
<sec:authorize access="hasRole('ROLE_ADMIN')">
      <a href="admin.jsp">admin</a>
   </sec:authorize>
</div>
</body>
</html>

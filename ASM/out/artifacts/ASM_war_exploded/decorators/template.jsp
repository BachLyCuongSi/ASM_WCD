<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
<head>
    <title>Template</title>
    <decorator:head/>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<decorator:body />
<%@include file="footer.jsp"%>
<%@include file="../js/js.jsp"%>
</body>
</html>

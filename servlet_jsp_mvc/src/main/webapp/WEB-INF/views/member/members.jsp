<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List"%>
<%@page import="ezen.mvcproject.domain.member.dto.Member"%>
<%@ page import="ezen.mvcproject.domain.member.dao.MemberDao"%>
<%@ page import="ezen.mvcproject.domain.common.database.DaoFactory"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
회원 목록
<table border="1">
	<c:forEach items="${members}" var="member" varStatus="loop">
		<tr>
			<td>${loop.count}</td>
			<td>${member.id}</td>
			<td>${member.name}</td>
			<td>${member.email}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
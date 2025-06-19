<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="member" class="ezen.member.Member" scope="session"/>
<jsp:setProperty property="name" name="member" value="김기정"/>
<jsp:setProperty property="id" name="member" value="bangry"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
</head>
<body>
이름 : ${"<김기정> 바보" }
이름 : <c:out value="<b>김기정</b> 바보" escapeXml="false"/>

</body>
</html>




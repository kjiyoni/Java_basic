<%@page import="ezen.common.database.DaoFactory"%>
<%@page import="ezen.member.Member"%>
<%@page import="ezen.member.JdbcMemberDao"%>
<%@page import="ezen.member.MemberDao"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%
request.setCharacterEncoding("utf-8");
String uid = request.getParameter("uid");
String upw = request.getParameter("upw");

//MemberDao memberDao = new JdbcMemberDao();
MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
Member loginMember = memberDao.findByUser(uid, upw);
if(loginMember == null){
%>
<html>
<head>
<script>
	// 추후 JavaScript2에서 Ajax를 이용한 비동기 통신 처리
	alert('아이디와 비밀번호를 확인하세요.');
	location.href= 'login.jsp';
</script>
</head>
</html>
<%	
} else{
	session.setAttribute("loginId", loginMember.getId());
	session.setAttribute("loginName", loginMember.getName());
	response.sendRedirect(application.getContextPath() + "/index.jsp");
}
%>

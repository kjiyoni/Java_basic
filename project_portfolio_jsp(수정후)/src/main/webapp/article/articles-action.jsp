<%@page import="ezen.portfolio.article.dao.MemoDao"%>
<%@page import="ezen.portfolio.common.dao.DaoFactory"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="memo" class="ezen.portfolio.article.dto.Memo" scope="request"/>
<jsp:setProperty name="memo" property="*"/>
<jsp:setProperty name="memo" property="memberId" value="${loginMember.id}"/>
<jsp:setProperty name="memo" property="memberName" value="${loginMember.name}"/>

<%
//memo.setContent(memo.getContent().replaceAll("\n", "<br>")) ;

MemoDao memoDao =  DaoFactory.getInstance().getMemoDao();
memoDao.create(memo);
// 전체목록으로 자동 요청
response.sendRedirect("/article/articlesv3.jsp");
%>





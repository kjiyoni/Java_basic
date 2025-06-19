<%@page import="java.util.List"%>
<%@page import="ezen.mvcframework.domain.member.dao.MemberDao"%>
<%@page import="ezen.mvcframework.domain.common.database.DaoFactory"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="ezen.mvcframework.domain.member.dto.Member"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@ page contentType="text/plain; charset=utf-8" %>
<%
	MemberDao memberDao = DaoFactory.getInstance().getMemberDao();
	List<Member> list = memberDao.findByAll();
	ObjectMapper objectMapper = new ObjectMapper();
	
	// 직렬화
	String members = objectMapper.writeValueAsString(list);
	out.println(members);
%>








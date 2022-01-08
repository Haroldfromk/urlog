<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<div style="text-align:right;">
	<c:choose>
		<c:when test="${sessionScope.userid == null}">
			<a href = "/urlog/member/login.do">로그인</a>
			</c:when>
		<c:otherwise>
			${sessionScope.member_name}님이 로그인 중입니다.
			<a href = "/urlog/member/logout.do">로그아웃</a>
			</c:otherwise>
	</c:choose>
	<br>
	<a href="/urlog/daily/list.do">데일리</a>
	<a href = "/urlog/photo/list.do">사진첩</a>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		$("#btnAdd").click(function() {
				location.href = "/urlog/daily/write.do";
		});
	});
	
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>일상 게시판</h2>
	<c:if test="${sessionScope.userid != null }">
		<button type="button" id="btnAdd">게시글 작성</button>
	</c:if>
	<table border="1" width="900px" style="text-align:center">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="row" items="${list}">
			<tr>
				<td>${row.d_idx}</td>
				<td><a href="/urlog/daily/detail/${row.d_idx}">${row.d_title}</a>
					<c:if test="${sessionScope.userid != null }">
					
						<br>
						<a href="/urlog/daily/edit/${row.d_idx}">[수정]</a>
					</c:if></td>
				<td width="40%" ><fmt:formatDate value="${row.d_post_date}"
						pattern="yyyy-MM-dd HH:mm:ss" /></td>
				<td>${row.d_readcount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
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
				location.href = "/urlog/photo/write.do";
		});
	});
</script>
<style>

body {
	box-sizing: border-box;
	font-family: Consolas, monospace;
}

h1 {
	text-align: center;
}

img {
	max-width: 100%;
}

.a {
	width: 200px;
	margin: 0px auto;
	float: left;
}

.a img {
	transition: all 0.2s linear;
}

.a:hover img {
	transform: scale(1.7);
}
</style>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>사진 게시판</h2>
	<c:if test="${sessionScope.userid != null }">
		<button type="button" id="btnAdd">사진등록</button>
	</c:if>
	<c:forEach var="row" items="${list}">
		<div class="a">
			<img src="/urlog/images/${row.p_filename}" width="150px" height="150px">
			<table width="150px" style="text-align:center;">
				<tr>
					<td><br><br></td>
				</tr>
				<tr>
					<td>
						${row.p_title}
					</td>
				</tr>
				<tr>
					<td><c:if test="${sessionScope.userid != null }">
						<button type="button" onclick="location.href='/urlog/photo/edit/${row.p_idx}'">수정</button>
						<%-- <input type="button" onclick="location<a href="">[수정]</a> --%>
					</c:if></td>
				</tr>
				
			</table>
		</div>
	</c:forEach>
</body>
</html>
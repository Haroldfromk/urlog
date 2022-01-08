<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>일상 게시글 작성</h2>
	<form action="/urlog/daily/insert.do" name="form1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="d_title"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="20" id="d_content"
						name="d_content"></textarea></td>
			</tr>
			<tr>
				<td>사진업로드</td>
				<td>&nbsp;<input type="file" name="file1"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type ="submit" value="등록">
			</tr>
		</table>
	</form>
</body>
</html>
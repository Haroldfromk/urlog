<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>게시글 보기</h2>
	<input type="button" value="목록" onclick="location.href='/urlog/daily/list.do'">
	<table border="1">
		<tr>
			<td align="center">
				<table>
					<tr>
						<td>제목</td>
					</tr>
					<tr>
						<td>${dto.d_title}</td>
					</tr>
					<tr>
						<td>사진</td>
					</tr>
					<tr>
						<td><img src="/urlog/images/${dto.d_filename}" width="300px"
								height="300px"></td>
					</tr>
					<tr>
						<td>내용</td>
					</tr>
					<tr>
						<td>${dto.d_content}</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
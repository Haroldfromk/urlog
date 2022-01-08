<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
$(function(){
	$("#btnUpdate").click(function(){
		document.form1.action="/urlog/member/update.do";
		document.form1.submit();
	});
	
	$("#btnDelete").click(function(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action="/urlog/member/delete.do";
			document.form1.submit();
		}
	});
});
</script>
</head>
<body>
<h2>상세 회원정보</h2>
<form name = "form1" method = "post">
	<table border="1" width = "700px">
		<tr>
			<td>아이디</td>
			<td><input type = "text" name = "userid" value="${dto.userid}" readonly></td> 
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type = "password" name = "member_passwd" ></td> 
		</tr>
		<tr>
			<td>이름</td>
			<td><input type = "text" name = "member_name" value ="${dto.member_name}"></td> 
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type = "text" name = "email" value="${dto.member_email}" ></td> 
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type = "text" name = "member_tel" value = "${dto.member_tel}"></td>
		</tr>
		<tr>
			<td>회원가입일자</td>
			<td>
				<fmt:formatDate value="${dto.join_date}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td> 
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type = "button" value = "수정" id = "btnUpdate">
				<input type = "button" value = "삭제" id = "btnDelete">
				<input type = "button" value = "뒤로가기" onclick="history.back()">
			</td>
		</tr>
	</table>
	<div style="color:red;">${message}</div>
</form>
</body>
</html>
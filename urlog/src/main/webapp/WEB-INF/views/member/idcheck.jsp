<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2> 아이디 중복확인 </h2>
	<form action="idCheck.do" method="post" name = "form">
		아이디 <input type = "text" name = "id" value = "${id}">
		<input type = "submit" value = "중복체크"><br>
		<br>
		<c:if test="${result==1}">
			<script>
				opener.document.form.id.value="";
			</script>
				${id}는 이미 사용중인 아이디입니다.
			</c:if>
			<c:if test="${result== -1}">
				${id}는 사용 가능한 아이디입니다.
			</c:if>
		<input type = "button" value ="사용" onclick = "idok()">
	</form>
</body>
</html>
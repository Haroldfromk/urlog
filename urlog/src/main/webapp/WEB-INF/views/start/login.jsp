<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function() {
		$("#btnLogin").click(function() {
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
			if (userid == "") {
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				return;
			}
			if (passwd == "") {
				alert("비밀번호를 입력하세요.");
				$("#passwd").focus();
				return;
			}
			document.form1.action = "/urlog/member/login_check.do";
			document.form1.submit();
		});
	});
</script>
</head>
<body>
	<h2>회원 로그인</h2>
	<form name="form1" method="post">
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td><input id="userid" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="member_passwd" name="member_passwd"></td>
			<tr>	
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">로그인</button>
					<a href = "../member/join.do"><input type = "button" value = "회원가입"/></a>
				</td>
			</tr>
			<tr>
				<c:if test="${message == 'error' }">
					<div style="color: red">아이디 또는 비밀번호가 일치하지 않습니다.</div>
				</c:if>
				<c:if test="${message == 'logout' }">
					<div style="color: red">로그아웃되었습니다.</div>
				</c:if>
				<c:if test="${param.message == 'nologin' }">
					<div style="color: red">로그인 하신 후 사용하세요.</div>
				</c:if>
				<c:if test="${message == 'out' }">
					<div style="color: red">탈퇴가 완료되었습니다.</div>
				</c:if>
			</tr>
		</table>
	</form>
</body>
</html>
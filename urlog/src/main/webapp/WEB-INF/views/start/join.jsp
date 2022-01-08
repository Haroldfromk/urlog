<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#idchkBtn").click(function(){
			var userid = $("#userid").val();
			if(userid = ""){
				alert("아이디를 입력해주세요.");
				$("#userid").focus();
				return;
			}
			
		});
	});
</script>
</head>
<body>
	<h2>회원 가입</h2>
	<form action = "/urlog/member/insert.do" method = "post" name="form">
		<table border = "1" width = "700px">
			<tr>
				<td>아이디</td>
				<td><input type = "text" name = "userid" id = "userid"/>
				<input type = "button" id="idchkBtn" value = "중복체크"/>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type = "password" name = "member_passwd"/>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type = "text" name = "member_name"/>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type = "text" name = "member_email"/>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type = "text" name = "member_tel"/>
			</tr>
			<tr>
				<td>블로그명</td>
				<td><input type = "text" name = "logo"/>
			</tr>
			<tr>
				<td colspan = "2" align="center">
					<input type = "submit" value ="등록"/>
				</td>	
			</tr>	
		</table>
	</form>	
</body>
</html>
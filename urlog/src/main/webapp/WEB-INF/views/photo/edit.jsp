<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function pdelete(){
    if(confirm("삭제하시겠습니까?")){
      document.form1.action="/urlog/photo/delete.do"
      document.form1.submit();
   } 
}
function pupdate(){
   var p_title=document.form1.p_title.value;
   if(p_title==""){
      alert("제목을 입력하세요.");
      document.form1.p_title.focus();
      return;
   }  
   document.form1.action="/urlog/photo/update.do";
   document.form1.submit();
}
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>사진 수정/삭제</h2>
	<form name="form1" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td align="center">
					<table>
						<tr>
							<td>제목</td>
						</tr>
						<tr>
							<td><input type="text" name="p_title" id="p_title"
								value="${dto.p_title}"></td>
						</tr>
						<tr>
							<td>사진</td>
						</tr>
						<tr>
							<td><img src="/urlog/images/${dto.p_filename}" width="300px"
								height="300px"></td>
							<input type="file" name="file1">
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="hidden" name="p_idx" value="${dto.p_idx}"> 
								<input type="button" value="수정" onclick="pupdate()"> 
								<input type="button" value="삭제" onclick="pdelete()"> 
								<input type="button" value="목록" onclick="location.href='/urlog/photo/list.do'">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
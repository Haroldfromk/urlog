<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function ddelete(){
    if(confirm("삭제하시겠습니까?")){
      document.form1.action="/urlog/daily/delete.do"
      document.form1.submit();
   } 
}
function dupdate(){
   var d_title=document.form1.d_title.value;
   var d_content=document.form1.d_content.value;
   if(d_title==""){
      alert("제목을 입력하세요.");
      document.form1.d_title.focus();
      return;
   }
   if(d_content==""){
      alert("내용을 입력하세요.");
      document.form1.d_content.focus();
      return;
   }    
   document.form1.action="/urlog/daily/update.do";
   document.form1.submit();
}
</script>
</head>
<body>
	<%@ include file="../include/menu.jsp"%>
	<h2>게시글 수정/삭제</h2>
	<form name="form1" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td align="center">
					<table>
						<tr>
							<td>제목</td>
						</tr>
						<tr>
							<td><input type="text" name="d_title" id="d_title"
								value="${dto.d_title}"></td>
						</tr>
						<tr>
							<td>사진</td>
						</tr>
						<tr>
							<td><img src="/urlog/images/${dto.d_filename}" width="300px"
								height="300px"></td>
							<input type="file" name="file1">
						</tr>
						<tr>
							<td>내용</td>
						</tr>
						<tr>
							<td><textarea rows="5" cols="60" name="d_content"
									id="d_content">${dto.d_content}</textarea></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input type="hidden" name="d_idx" value="${dto.d_idx}"> 
								<input type="button" value="수정" onclick="dupdate()"> 
								<input type="button" value="삭제" onclick="ddelete()"> 
								<input type="button" value="목록" onclick="location.href='/urlog/daily/list.do'">
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
	<title>Home</title>
	<style>

		#div{
			border: 1px solid #f2f2f2;
			margin-left: 50px;
			margin-rigth: 50px;
			float: left;
		}
		#div1{
			border: 1px solid #f2f2f2;
			padding: 1px;
			margin-left: 5px;
			margin-rigth: 5opx;
			float: left;
		}
		#img2{
			margin-top: 5px;
			margin-left: 5px;
			margin-rigth: 5px;
			margin-botton: 5px;
			float : top;
			width: 100px;
		}
		h1{
			text-align: center;
			width: 100%;
		}
		hr{
			border-top: 1px solid #d9d9d9;
			width: 100%;
		}
		
	</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div style="line-height:200%">
<%@ include file = "../include/menu.jsp" %>
<h1>${sessionScope.logo}</h1><br>
</div>

<hr>
	<p style="margin-top:40px; text-align: center;">
	<a href = "/urlog/daily/list.do">daily</a> &nbsp;&nbsp; | &nbsp;&nbsp;
	<a href = "/urlog/travel/list.do">travel</a> &nbsp;&nbsp; | &nbsp;&nbsp;
	<a href = "/urlog/hobby/list.do">hobby</a> &nbsp;&nbsp; | &nbsp;&nbsp;
	<a href = "/urlog/photo/list.do">photo</a> &nbsp;&nbsp; | &nbsp;&nbsp;
	<a href = "/urlog/guest/list.do">quest</a></p>
	
		<div id= "div" style="width: 1000px; height: 400px" >
			<img id = "img1" src="/urlog/images/${h_filename}">
		</div>
		<div id = "div1">
			<img id = "img2" src="/urlog/images/${h_filename}" width="500px" height="150px"><br>
			안녕하세요 블로그 입니다.
		</div>
		<div></div>
</body>
</html>
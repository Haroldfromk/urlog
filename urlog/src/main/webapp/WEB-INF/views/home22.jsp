<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
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
	width: 400px;
	margin: 0px auto;
}

.a img {
	transition: all 0.2s linear;
}

.a:hover img {
	transform: scale(1.8);
}
</style>
</head>
<body>
	<%@ include file="include/menu.jsp"%>

	<h1>Hello world!</h1>
	<a href="/urlog/daily/list.do">데일리</a>
	<a href = "/urlog/photo/list.do">사진첩</a>
	<P>The time on the server is ${serverTime}.</P>

	<div class="a">
		<img src="/urlog/images/moo.jpg">
	</div>


</body>
</html>

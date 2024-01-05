<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<c:set var="pc" value="${pageContext.request.contextPath }"></c:set>
<head>
	<title>solo</title>
	<style type="text/css">
		body{
			margin: 0;
			padding: 0;
		}
		#header-button {
			color: gray;
		}
		#header-button > a{
			font-size: 10.5;
			margin-left: 1%; 
			margin-right: 1%;
		}
		#header-menu{
			display: flex;
			border-radius: 6px;
			box-shadow: -1px 3px 2px rgb(0, 0, 0, 0.2);
		}
		#header-menu > div{
			margin-left: 2%;
			margin-right: 2%;
			margin-top: 1%;
			margin-bottom: 1%;
		}
	</style>
</head>
<body>
<div align="center" >
	<div style="width: 46.8%;">
		<div id = "header" >
			<div id = "header-button" align="right" >
				|<a href="${pc }">로그인</a>|<a>주문 조회</a>
			</div>
			<div id = "header-menu">
				<div><a href="${pc }"><img src="resources/img/logo.jpg" width="115px"></a></div>
				<div><a>메뉴</a></div>
				<div><a>마이페이지</a></div>
				<div>기타정보</div>
			</div>
		</div>
	</div>
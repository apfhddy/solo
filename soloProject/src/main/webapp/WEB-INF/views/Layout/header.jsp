<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<c:set var="finalPath" value="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }"></c:set>
<c:set var="pc" value="${pageContext.request.contextPath }"></c:set>
<head>
	<title>solo</title>
	<style type="text/css">
		a{
			color: inherit;
			text-decoration: none;
			cursor: pointer;
		}
		body{
			margin: 0;
			padding: 0;
			background-color: #F3F3F3;
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
			margin-top: 0.5%;
			margin-bottom: 0.5%;
		}
		#header-menu:nth-child(1){ 
			background-color: white;
		}
		#header-menu:nth-child(2){ 
			background-color: white;
		}
		#header-menu:nth-child(3){ 
			background-color: white;
		}
		#header-menu:nth-child(4){ 
			background-color: white;
		}
		#popUp{
			width: 100%;
			height: 100%;
			position: absolute;
			z-index: 99;
			background-color: rgb(255,255,255,0.6);
		}
		
		#loginPop{
			width: 28.5%;
			margin-top: 1.2%;
			background-color: white;
			box-shadow: 0px 0px 10px rgb(0, 0, 0, 0.6);
			border-radius: 3px;
			padding-top: 0.8%;
			padding-bottom: 1%;
		}
		
		#loginPop-logo{
			margin-bottom: 3%;
		}
		
		
		#detailPop{
			position: absolute;
			width: 100%;
			height: 100%;
			z-index: 100;
			background-color: #F3F3F3;
		}
		.detailPop-header{
			height: 13%;
			background-color: white;
			box-shadow: 0px 2px 10px rgb(0, 0, 0, 0.3);
		}
		.detailPop-footer{
			width: 100%;
			height: 7%;
			position:absolute;
			bottom:0;
			background-color: white;
			box-shadow: 0px -2px 10px rgb(0, 0, 0, 0.3);
		}
		.detailPop-body{
			height: 80%;
			width: 45.8%;
		}
		
		.detailPop-table-tr{
			text-align:center; 
			font-size: 13;
		}
		
		.detailPop-table-tr td:nth-child(1){
			width: 15%;
		}
		.detailPop-table-tr td:nth-child(2){
			width: 8%;
		}
		.detailPop-table-tr td:nth-child(3){
			width: 40%;
			text-align: left;
		}
		.detailPop-table-tr td:nth-child(4){
			width: 18%;
			text-align: right;
		}
		.detailPop-table-tr td:nth-child(5){
			width: 19%;
			text-align: right;
		}
		
		
		
		input:focus {
			outline: none; 
		}
		.login-input{
			width: 100%; 
			height: 40px; 
			padding-left: 7%;
		}
		.login-button{ 
			width: 100%; 
			height: 40px; 
		}
	</style>
</head>
<body>
<div align="center">
	<%@include file="popup.jsp" %>
	<div style="width: 45.8%;">
		<div id = "header" >
			<div id = "header-button" align="right" >
				<a><img style="${login != null ? 'filter: invert(68%) sepia(29%) saturate(6659%) hue-rotate(176deg) brightness(106%) contrast(95%);' : ''}'" src="${finalPath }/resources/img/userSwitch.png" width="15"> &nbsp;&nbsp;${login != null ? login.name :'' }</a>
				|
				<c:choose>
					<c:when test="${login == null }">
						<a onclick="login_Pop()">로그인</a>
					</c:when>
					<c:otherwise>
						<a  href = '${pc}/login/logOut'>로그아웃</a>
					</c:otherwise>
				</c:choose>
				|<a>주문 조회</a>
			</div>
			<div id = "header-menu">
				<div><a href="${pc }"><img src="${finalPath }/resources/img/logo.jpg" width="115px"></a></div>
				<div><a href="${pc }/menu">메뉴</a></div>
				<div>
					<c:choose>
						<c:when test="${login == null }">
							<a onclick="login_Pop()">마이페이지</a>
						</c:when>
						<c:otherwise>
							<a href="${pc }/myPage">마이페이지</a>
						</c:otherwise>
					</c:choose>
				</div>
				<div>기타정보</div>
			</div>
		</div>
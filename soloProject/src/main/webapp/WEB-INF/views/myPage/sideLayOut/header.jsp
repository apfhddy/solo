<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../Layout/header.jsp" %>
<% String nowUrl = ((String)request.getAttribute("javax.servlet.forward.request_uri")).replace("/solo/myPage/", "");%>
<style>
	.menu{
		margin-top: 2%;
		width: 15%;
		margin-right: 1%;
	}
	.menu > div{
		font-size: 14;
		margin-bottom: 5%; 
	}
	.menu-header{
		font-size: 17;
		margin-top: 1%; 
		margin-bottom: 1%;
	}
</style>
<div align="left" style="display: flex;">
	<div class = "menu">
		<div style="color: gray">
		마이 페이지
		</div>
		<hr>
		<div>
			<a>• 주문 조회</a>
		</div>
		<div>
			<a>• 주문 내역</a>
		</div>
		<div>
			<a>• 즐겨찾기 메뉴</a>
		</div>
		<div>
			<a><span style="color: <%=nowUrl.equals("addr") ? "orange" : "gray"%>">•</span> <span style="color: <%=nowUrl.equals("addr") ? "red" : ""%>">주소록</span></a>
		</div>
		<div> 
			<a href="myPage/userData"><span style="color: <%=nowUrl.equals("addr") ? "orange" : "gray"%>">•</span> <span style="color: <%=nowUrl.equals("addr") ? "red" : ""%>">계정 설정</span></a>
		</div>
		<div>
			<a>• 비밀번호 변경</a>
		</div>
	</div>
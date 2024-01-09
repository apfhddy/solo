<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">비밀번호 변경</div>
	<div style="background-color: white; padding-top: 2%; padding-left: 2%; padding-bottom: 2%;">
		<form action="${pc }/myPage/password/Update">
			<div class="input-container">
				<input type = "password" name = "nowPassword">
				<label for="name">기존 비밀번호</label>
			</div>
			<div class="input-container">
				<input type = "password" name = "newPassword">
				<label for="name">새로운 비밀번호</label>
			</div>
			<div class="input-container">
				<input type = "password" name = "newPasswordCheck">
				<label for="name">새로운 비밀번호 재입력</label>
			</div>
			<input type = "button" value = "비밀번호 저장">
			<input type = "submit">
		</form>
	</div>
</div>
<%@ include file="sideLayOut/footer.jsp" %>
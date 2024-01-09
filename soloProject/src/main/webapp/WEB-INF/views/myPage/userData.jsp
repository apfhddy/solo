<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">계정 설정</div>
	<div style="background-color: white; padding-top: 2%; padding-left: 2%;">
		<form action="${pc }/myPage/userData/update" method="post"> 
			<div align="left" style="margin-top: 2%;">
				<div class="input-container">
					<input name = "name" value = "${login.name }">
					<label for="name">Name</label>
				</div>
				<div>
					성별
					<select name = "gender">
						<option ${login.gender == 0 ? "selected" : "" } value = "0">선택 안함</option>
						<option ${login.gender == 1 ? "selected" : "" } value = "1">남</option>
						<option ${login.gender == 2 ? "selected" : "" } value = "2">여</option>
					</select>
				</div>
				<div class="input-container">
					<input name = "phone" value="${login.phone }" maxlength="11" type = "number">
					<label for="name">Name</label>
				</div>
				<div>
					<div>
						<input name = "certified" type = "radio">이메일 : ${login.email }
					</div>
					<div>
						<input name = "certified" type = "radio">휴대전화 : ${login.phone }
					</div>				
				</div>
				<div>
					<input type = "checkbox">대충 프로모션 해택
				</div>
				<div>
					<input type = "checkbox">대충 개인정보 수집 및 이용
				</div>
			</div>
			<input type="submit" value = "수정사항 저장">
			<input type="button" value = "회원 탈퇴">
		</form>
	</div>
</div>
<%@ include file="sideLayOut/footer.jsp" %>
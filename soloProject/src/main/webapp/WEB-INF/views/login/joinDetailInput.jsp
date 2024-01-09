<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Layout/header.jsp" %>
<form action="${pc }/join/certified" method="post"> 
<div align="left">
	<div>
		이름<input name = "name" value = "www">
	</div>
	<div>
		성별
		<select name = "gender">
			<option value = "0">선택 안함</option>
			<option value = "1">남</option>
			<option value = "2">여</option>
		</select>
	</div>
	<div>
		휴대전화 번호
		<input name = "phone" value="01011111111" type = "number">
	</div>
	<div>
		이메일
		<input name = "email" value="eee@naver.com" type = "email">
	</div>
	<div>
		이메일 확인
		<input type = "email">
	</div>
	<div>
		비밀번호
		<input name = "pw" value="qwer" type = "password">
	</div>
	<div>
		비밀번호 확인
		<input type = "password">
	</div>
	<div>
		<input name = "certified" type = "radio">이메일
		<input name = "certified" type = "radio">휴대전화
	</div>
	<div>
		<input type = "checkbox">대충 프로모션 해택
	</div>
	<div>
		<input type = "checkbox">대충 개인정보 수집 및 이용
	</div>
</div>
<input type="submit" value = "생성">
</form>
<%@ include file="../Layout/footer.jsp" %>
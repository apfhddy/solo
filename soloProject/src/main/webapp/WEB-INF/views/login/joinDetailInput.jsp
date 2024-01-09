<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Layout/header.jsp" %>
<style>
		      /* 스타일링 예제 */
        .input-container {
            position: relative;
            margin-bottom: 2%;
            margin-top: 2%;
        }

        label {
            position: absolute;
            top: 8px;
            left: 10px;
            color: #888;
            font-size: 17; 
            pointer-events: none;
            transition: 0.2s ease-out all;
        }

       .input-container > input {
            width: 70%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

       .input-container > input:focus + label, input:not(:placeholder-shown) + label {
            top: -12px;
            left: 8px;
            font-size: 12px;
            color: #333;
            background-color: #fff;
            padding: 2px 6px;
            border-radius: 4px;
        }
</style>
<form action="${pc }/join/certified" method="post"> 
<div align="left" style="margin-top: 2%;">
	<div class="input-container">
		<input name = "name" value = "www">
		<label for="name">Name</label>
	</div>
	<div>
		성별
		<select name = "gender">
			<option value = "0">선택 안함</option>
			<option value = "1">남</option>
			<option value = "2">여</option>
		</select>
	</div>
	<div class="input-container">
		<input name = "phone" value="01011111111" maxlength="11" type = "number">
		<label for="name">Phone</label>
	</div>
	<div class="input-container">
		<input name = "email" value="eee@naver.com" type = "email">
		<label for="name">Email</label>
	</div>
	<div class="input-container">
		<input type = "email">
		<label for="name">Check-Email</label>
	</div>
	<div class="input-container">
		<input name = "pw" value="qwer" type = "password">
		<label for="pw">Password</label>
	</div>
	<div class="input-container">
		<input type = "password">
		<label for="name">Check-Password</label>
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
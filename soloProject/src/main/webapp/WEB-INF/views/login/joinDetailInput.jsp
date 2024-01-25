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
	<div style="font-size: 17; color: orange;">회원 정보</div>
	<div style="font-size: 12; color: gray; margin-top: 1%; margin-bottom: 1%;">* 필수 항목</div>
	<div id = "detailErr" style="font-size: 10; color: red;"></div>
	<div class="input-container">
		<input name = "name">
		<label for="name">*Name</label>
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
		<input onkeydown="phoneEt(event,this)" name = "phone" maxlength="11" type = "number">
		<label for="name">*Phone</label>
	</div>
	<div class="input-container">
		<input name = "email" type = "email">
		<label for="name">*Email</label>
	</div>
	<div class="input-container">
		<input name = "emailCk" type = "email">
		<label for="name">*Check-Email</label>
	</div>
	<div class="input-container">
		<input name = "pw" type = "password">
		<label for="pw">*Password</label>
	</div>
	<div class="input-container">
		<input name = "pwCk" type = "password">
		<label for="name">*Check-Password</label>
	</div>
	<div style="padding-top: 1%; margin-bottom: 2%;">
		인증방법
		<c:forEach var="certified" items="${certifiedList }" varStatus="i">
			<div><input ${i.index == 0 ? 'checked' : '' } name = "certifiedType_no" value="${certified.certifiedType_no }" type = "radio">${certified.name }</div>
		</c:forEach>
	</div>
	<c:forEach var="terms" items="${termsList }">
		<div>
			<input name = "terms${terms.terms_no }" value="${terms.terms_no }" type = "checkbox">${terms.detail }
		</div>
	</c:forEach>
</div>
<input type="button" onclick="detailCheck(this.form)" value = "생성">
</form>
<script type="text/javascript">
	function detailCheck(t){
		
		let ajaxThreed = false;
		const name = t.name.value;
		const phone = t.phone.value;
		const email = t.email.value;
		const emailCk = t.emailCk.value;
		const pw = t.pw.value;
		const pwCk = t.pwCk.value;
		
		/* console.log(name);
		console.log(phone);
		console.log(email);
		console.log(emailCk);
		console.log(pw);
		console.log(pwCk); */
		function checkEmailorPhone(type,value,callBack){
			$.ajax({
				url:"${pc}/check/emailOrPhone",
				data:{type:type,value:value},
				type:"post",
				success: (result) => {
					if(!result)return dtErr(type == 0 ? '031' : '032');
					callBack();
				}
			})
		}
		
		function dtErr(code){
			detailErr.innerText = errMessage[code];
		}
		
		if(name.trim() == "")return dtErr('021');
		
		if(phone == "")return dtErr('022');		
		if(phone.length < 11)return dtErr('023');
		if(!phone_pt.test(phone))return dtErr('033')
		checkEmailorPhone(1,phone,emailCheck);
		
		function emailCheck(){
			if(email.trim() == "")return dtErr('024');
			if(!email_pt.test(email))return dtErr('002');
			if(emailCk.trim() == "")return dtErr('025');
			if(!email_pt.test(emailCk))return dtErr('002');
			if(email != emailCk)return dtErr('026');
			checkEmailorPhone(0,email,passwordCheck);
		}
		
		function passwordCheck(){
			if(pw.trim() == "")return dtErr('004');
			if(!pw_pt.test(pw))return dtErr('028');
			if(pwCk.trim() == "")return dtErr('027');
			if(!pw_pt.test(pwCk))return dtErr('029');
			if(pw != pwCk)return dtErr('030');
			t.submit();
		}
		
		
	}
	
	function phoneEt(e,t){
		if(e.keyCode == 189 || t.value.length > 10 && e.keyCode > 47 && e.keyCode < 58)e.preventDefault();
		let v = t.value;
		setTimeout(function() {
			if(t.value.length > 11){
				t.value = v;
			}
		}, 0)
	}
	
	
</script>
<%@ include file="../Layout/footer.jsp" %>
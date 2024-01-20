<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">비밀번호 변경</div>
	<div style="background-color: white;box-shadow: 0px 0px 2px gray; padding-top: 2%; padding-left: 2%; padding-bottom: 2%;">
		<form action="${pc }/myPage/password/Update">
			<div id = "passwordErr" style="font-size: 10; color: red;"></div>
			<div class="input-container">
				<input type = "password" name = "nowPw">
				<label for="name">기존 비밀번호</label>
			</div>
			<div class="input-container">
				<input type = "password" name = "newPw">
				<label for="name">새로운 비밀번호</label>
			</div>
			<div class="input-container">
				<input type = "password" name = "newPwCk">
				<label for="name">새로운 비밀번호 재입력</label>
			</div>
			<input onclick="passwordCheck(this.form)" type = "button" value = "비밀번호 저장">
		</form>
	</div>
</div>
<script type="text/javascript">
	function passwordCheck(t){
		const nowPw = t.nowPw.value;
		const newPw = t.newPw.value;
		const newPwCk = t.newPwCk.value;
		
		function pwErr(code){
			passwordErr.innerText = errMessage[code];
		}
		
		if(nowPw.trim() == "")return pwErr('040');
		if(!pw_pt.test(nowPw))return pwErr('028');
		
		$.ajax({
			url:"${pc}/check/password",
			type:"post",
			data:{pw:nowPw},
			success: (result) => {
				if(!result)return pwErr('042');
	
				if(newPw.trim() == "")return pwErr('040');
				if(!pw_pt.test(newPw))return pwErr('028');
				if(newPw != newPwCk)return pwErr('030');
				
				t.submit();
			}
		});
		
		
		
		
	}

</script>
<%@ include file="sideLayOut/footer.jsp" %>
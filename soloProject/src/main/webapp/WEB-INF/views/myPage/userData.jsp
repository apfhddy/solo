<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">계정 설정</div>
	<div style="background-color: white; padding-top: 2%; padding-left: 2%; box-shadow: 0px 0px 2px gray;">
		<form action="${pc }/myPage/userData/update" method="post">
			<div id = "dataErr" style="font-size: 10; color: red;"></div>
			<div align="left" style="margin-top: 2%;">
				<div class="input-container">
					<input name = "name" value = "${login.name }">
					<label for="name">Name</label>
				</div>
				<div>
					성별
					<select name = "gender">
						<option ${login.gender == 0 ? "selected" : '' } value = "0">선택 안함</option>
						<option ${login.gender == 1 ? "selected" : '' } value = "1">남</option>
						<option ${login.gender == 2 ? "selected" : '' } value = "2">여</option>
					</select>
				</div>
				<div class="input-container">
					<input onkeydown="phoneEt(event,this)" name = "phone" value="${login.phone }"type = "number">
					<label for="name">Phone</label>
				</div>
				<div>
					<div style="padding-top: 1%; margin-bottom: 2%;">
						인증방법
						<c:forEach var="certified" items="${certifiedList}">
							<div>
								<input ${login.certifiedType_no ==  certified.certifiedType_no ? 'checked' : ''} name ="certified" value = "${certified.certifiedType_no }" type = "radio">
								<c:choose>
									<c:when test="${certified.certifiedType_no == 1}">${certified.name} : ${login.email }</c:when>
									<c:when test="${certified.certifiedType_no == 2}">${certified.name} : ${login.phone }</c:when>
								</c:choose>
							</div>
						</c:forEach>
					</div>
				</div>
				<c:forEach var="userTerms" items="${userTermsList }">
					<div>
						<input ${userTerms.CHECKED == 1 ? 'checked' : '' } name = "terms${userTerms.TERMS_NO }" type = "checkbox">${userTerms.DETAIL }
					</div>
				</c:forEach>
			</div>
			<input type="button" onclick="checkForm(this.form)" value = "수정사항 저장">
			<input type="button" value = "회원 탈퇴">
		</form>
	</div>
</div>
<script type="text/javascript">
	function checkForm(t){
		const name = t.name.value;
		const phone = t.phone.value;
		
		function dtErr(code){
			dataErr.innerText = errMessage[code];
		}
		
		if(name.trim() == "")return dtErr('021');
		
		if(phone == "")return dtErr('022');		
		if(phone.length < 11)return dtErr('023');
		if(!phone_pt.test(phone))return dtErr('033')
		
		t.submit();
		
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
<%@ include file="sideLayOut/footer.jsp" %>
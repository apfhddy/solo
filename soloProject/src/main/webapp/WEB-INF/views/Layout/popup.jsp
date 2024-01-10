<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "popUp" style="display: none;">
	<div id = "loginPop">
		<div id = "loginPop-logo">
			<img src="${finalPath }/resources/img/logo.jpg" width="108px">
		</div>
		<div>
			주문을 하시려면 	로그인하시기 바랍니다.
			<div>
				<form action="${pc }/login">
					<table style="width: 40%;">
						<tr>
							<td style="width: 50%; border-right: 1px solid; text-align: center;">로그인</td>
							<td style="width: 50%; text-align: center;">비회원주문</td> 
						</tr>
						<tr>
							<td colspan="2">
								<input name = "id" class="login-input" placeholder="아이디">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input name = "pw" type = "password" class="login-input" placeholder="비밀번호">
							</td>
						</tr>
						<tr>
							<td id="loginPopErr" style="font-size: 10; color: red;" colspan="2"></td>
						</tr>
						<tr>
							<th colspan="2"><input onclick="login(this.form,loginPopErr)" class="login-button" type = "button" value = "로그인"></th>
						</tr>
						<tr>
							<th colspan="2"><input onclick="document.location.href='${pc}/join/addr'" class="login-button" type = "button" value = "회원가입"></th>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	
	function pop(target){
		popUp.style.display = '';
		
		function popRemove(e){
			if(!target.contains(e.target)){
				popUp.removeEventListener("mousedown",popRemove);
				popUp.style.display = 'none';
			}
		}
		popUp.addEventListener("mousedown", popRemove);
	}

	function login_Pop() {
		pop(loginPop);
	}
	

</script>
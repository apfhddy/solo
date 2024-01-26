<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "popUp" style="display: none; ">
	<div id = "detailPop" style="display: none;">
		<div class="detailPop-header">
			<div style="width: 900px; display: flex; padding-top: 0.5%;" align="left">
				<div align="center" style="margin-left: 1%; margin-right: 1%; width: 3%;">
					<div id="detailPopNum" style="font-size: 40; color: red">0</div>
					<div style="font-size: 11;">수량</div>
				</div>
				<div  style="margin-left: 1%; margin-right: 1%; padding-top: 1%; width: 14%;" align="center">
					<img id = "detailPopImg" src="" width="100%">
				</div>
				<div id = "detailPopName" style="margin-left: 1%; margin-right: 1%; font-size: 24;">
				</div>
				<div style="width: 3%; margin-left: auto; cursor: pointer;">
					<img src="${finalPath }/resources/img/x.png;" width="100%" onclick="pop(detailPop,'del')">
				</div>
			</div>
		</div>
		<div class="detailPop-body" align="left">
			<div>
				<table id ="detailPopTable">
					<tr style="font-size: 14; color: gray;">
						<td colspan="3">1단계: 메뉴를 선택하세요</td>
						<td align="right">가격</td>
						<td align="right">KCAL</td> 
					</tr> 
				</table>
			</div>
			<hr style="border: 1px solid gray; ,margin-bottom: 1%;">
			<div style="font-size: 14; color: gray; margin-bottom: 1%;">
				2 단계: 메뉴 항목을 선택하세요
			</div>
			<div id = "orderBody">
				
			</div>
			<hr style="border: 1px solid gray;">
		</div>
		<div class="detailPop-footer" >
			<div style="width: 45.8%;" align="left">
				<input type = "button" value="메뉴로 돌아가기" onclick="pop(detailPop,'del')">
				<input type = "button" value="카트에 추가하기" onclick="menuFunction['addCart']()">
			</div>
		</div>
	</div>
	<div id = "loginPop" style="display: none;">
		<div id = "loginPop-logo">
			<img src="${finalPath }/resources/img/logo.jpg" width="108px">
		</div>
		<div>
			주문을 하시려면 	로그인하시기 바랍니다.
			<div>
				<form action="${pc }/login" onkeypress="if(event.keyCode == 13)login(this,loginPopErr)">
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
							<td colspan="2" align="right" style="font-size: 11;"><a href="${pc }/findPassword">비밀번호 찾기</a></td>
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
	function pop(target,t){
		if(t == 'del'){
			document.removeEventListener("mousedown",popRemove);
			popUp.style.display = 'none';
			target.style.display = 'none';
			return
		}
		target.style.display = '';
		popUp.style.display = '';
		function popRemove(e){
			if(!target.contains(e.target)){
				document.removeEventListener("mousedown",popRemove);
				popUp.style.display = 'none';
				target.style.display = 'none';
			}
		}
		document.addEventListener("mousedown", popRemove);
	}

	function login_Pop() {
		pop(loginPop);
	}

</script>
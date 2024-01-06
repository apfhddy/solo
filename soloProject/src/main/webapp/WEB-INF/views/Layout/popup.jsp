<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "popUp" style="display: none;">
	<div id = "loginPop">
		<div id = "loginPop-logo">
			<img src="${pc }/resources/img/logo.jpg" width="108px">
		</div>
		<div>
			주문을 하시려면 	로그인하시기 바랍니다.
			<div>
				<table style="width: 40%;">
					<tr>
						<td style="width: 50%; border-right: 1px solid; text-align: center;">로그인</td>
						<td style="width: 50%; text-align: center;">비회원주문</td> 
					</tr>
					<tr>
						<td colspan="2">
							<input class="login-input" placeholder="아이디">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input class="login-input" placeholder="비밀번호">
						</td>
					</tr>
					<tr>
						<th colspan="2"><input class="login-button" type = "button" value = "로그인"></th>
					</tr>
					<tr>
						<th colspan="2"><input onclick="document.location.href='${pc}/join/addr'" class="login-button" type = "button" value = "회원가입"></th>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

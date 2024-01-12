<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Layout/header.jsp" %>
<style>
	#mainBody-login{
		background-image: url("${finalPath }/resources/img/main.jpg");
		background-position: center center;
		background-size: cover;
		height: 370px;
		margin-top: 1%;
		width: 100%;
		border-radius: 4px;
	}
</style>
<div>
	<div id = "mainBody-login" align="right">
		<div style="padding-top: 1.7%; padding-right: 1.7%;">
			<div style="background-color: rgb(255,255,255,0.6); width: 28%; padding-top: 1%; padding-bottom: 0.2%; border-radius: 2px;" align="center">
				<div>
					주문 시작하기
					<div>
						<form action="${pc }/login">
							<table style="width: 90%;">
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
									<td id="loginMainErr" style="font-size: 10; color: red;" colspan="2"></td>
								</tr>
								<tr>
									<th colspan="2"><input onclick="login(this.form,loginMainErr)" class="login-button" type = "button" value = "로그인"></th>
								</tr>
								<tr>
									<td colspan="2" align="right" style="font-size: 11;"><a>비밀번호 찾기</a></td>
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
	</div>
	<hr style="margin-top: 4%;">
	<div align="left">
		<div style="font-size: 20; margin-bottom: 2%;">
			맥딜리버리 이용 방법!
		</div>
		<img src="${finalPath }/resources/img/guid.png" width="100%">
	</div>
</div>
<%@ include file="Layout/footer.jsp" %>

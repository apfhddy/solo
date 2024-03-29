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
		<div style="padding-top: 1.7%; padding-right: 1.7%; ">
			<div style="background-color: rgb(255,255,255,0.68); width: 28%; padding-top: 1%; padding-bottom: 1%; border-radius: 2px;" align="center"> 
				<c:choose>
					<c:when test="${login == null }">
						<div>
							주문 시작하기
							<div>
								<form action="${pc }/login" onkeypress="if(event.keyCode == 13)login(this,loginMainErr)">
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
											<td colspan="2" align="right" style="font-size: 11;"><a href="${pc }/findPassword">비밀번호 찾기</a></td>
										</tr>
										<tr>
											<th colspan="2"><input onclick="document.location.href='${pc}/join/addr'" class="login-button" type = "button" value = "회원가입"></th>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div style="font-size: 14;">
							환영합니다 ${login.name } 고객님
						</div>
						<hr>
						<div style="padding-left: 5%; padding-right: 5%;">
							<div align="left">다음의 주소로 배달됩니다.</div>
							<div>
								<select onchange="addrChange(this)" style="width: 100%; height: 30px;">
									<c:forEach var="addr" items="${address }">
										<option ${login.userAddr_no == addr.userAddr_no ? 'selected' : '' } value="${addr.userAddr_no }">${addr.location } ${addr.detail } ${addr.significant }</option>
									</c:forEach>
								</select>
							</div>
							<div>
								<input type="button" value="새로 주문하기" style="margin-top:2%; width: 90%; height: 35px;" onclick="document.location.href='${pc}/menu'">
							</div>
						</div>
					</c:otherwise>
				</c:choose>
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
<script type="text/javascript">
	function addrChange(t){
		let v = t.value;
		$.ajax({
			url:"${pc}/addr/change",
			data:{v:v},
			type:"post",
			success: ()=>{
				document.location.reload()
			}
		})
	}
</script>
<%@ include file="Layout/footer.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Layout/header.jsp" %>
<div align="left">
	<div style="font-size: 20; margin-top: 1%;margin-bottom: 1%; ">회원인증</div>
	<div style="background-color: white; padding-left:3% ; height: 200px;">
		<div style="padding-top: 1%;padding-bottom: 1%;">
			고객님께 이메일을 전송했습니다.
		</div>
		<div>
			<pre>
입력한 이메일 주소 <b>${join.detail.email }</b> 로 인증메일이 발송되었습니다.

회원 가입을 위해 이메일 내용을 확인하세요.

5분안에 인증 메일을 받지 못하신 경우, 스팸 메일을 확인하시거나 인증 메일 재발송을 위해 <a style="color: blue; font-weight: bold;" onclick="retryEmail()">여기</a>를 클릭하세요.
			</pre>
		</div>
	</div>
</div>
<%@ include file="../Layout/footer.jsp" %>
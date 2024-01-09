<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../Layout/header.jsp" %>
<% String nowUrl = ((String)request.getAttribute("javax.servlet.forward.request_uri")).replace("/solo/myPage/", "");%>
<style>
	.menu{
		margin-top: 2%;
		width: 15%;
		margin-right: 1%;
	}
	.menu > div{
		font-size: 14;
		margin-bottom: 5%; 
	}
	.menu-header{
		font-size: 17;
		margin-top: 1%; 
		margin-bottom: 1%;
	}
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
           width: 90%;
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
<div align="left" style="display: flex;">
	<div class = "menu">
		<div style="color: gray">
		마이 페이지
		</div>
		<hr>
		<div>
			<a>• 주문 조회</a>
		</div>
		<div>
			<a>• 주문 내역</a>
		</div>
		<div>
			<a>• 즐겨찾기 메뉴</a>
		</div>
		<div>
			<a href="${pc}/myPage"><span style="color: <%=nowUrl.equals("addr") ? "orange" : "gray"%>">•</span> <span style="color: <%=nowUrl.equals("addr") ? "red" : ""%>">주소록</span></a>
		</div>
		<div> 
			<a href="${pc}/myPage/userData"><span style="color: <%=nowUrl.equals("userData") ? "orange" : "gray"%>">•</span> <span style="color: <%=nowUrl.equals("userData") ? "red" : ""%>">계정 설정</span></a>
		</div>
		<div>
			<a href="${pc}/myPage/password"><span style="color: <%=nowUrl.equals("password") ? "orange" : "gray"%>">•</span> <span style="color: <%=nowUrl.equals("password") ? "red" : ""%>">비밀번호 변경</span></a>
		</div>
	</div>
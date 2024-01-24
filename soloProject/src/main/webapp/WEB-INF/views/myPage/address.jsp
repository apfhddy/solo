<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">주소록</div>
	<div style="background-color: white; box-shadow: 0px 0px 2px gray;">
		<table style="width: 100%; padding-left: 1%;"> 
			<tr>
				<td style="width: 50%;">주소</td>
				<td style="width: 30%;">배달 시 유의사항</td>
				<td style="width: 20%;"></td>
			</tr>
			<c:forEach var="addr" items="${address }" varStatus="i">
				<tr>
					<td><span style=""> ${i.count } </span><span style="font-size: 11;">${addr.location } ${addr.detail }</span></td>
					<td>${addr.significant }</td>
					<td align="right"><input onclick="document.location.href='${pc}/myPage/addr/form?addressType=${i.count}'" type = "button" value = "수정"><input onclick="document.location.href='${pc}/myPage/addr/delete?addressType=${i.count}'" ${addr.userAddr_no == login.userAddr_no ? 'disabled' : ''  }  type = "button" value="${addr.userAddr_no == login.userAddr_no ? '사용중' : '삭제'  }"></td>				
				</tr>
			</c:forEach>
			<tr>
				<td align="right" colspan="3">
					<input type = "button" value="새로운 주소 추가" onclick="document.location.href='${pc}/myPage/addr/form'">
					<input type = "button" value="메인화면으로 이동" onclick="document.location.href='${pc}/'">
				</td>
			</tr>
		</table>
	</div>
</div>
<%@ include file="sideLayOut/footer.jsp" %>
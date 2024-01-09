<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">주소록</div>
	<div style="background-color: white;">
		<table style="width: 100%"> 
			<tr>
				<td style="width: 50%;">주소</td>
				<td style="width: 30%;">배달 시 유의사항</td>
				<td style="width: 20%;"></td>
			</tr>
			<c:forEach var="addr" items="${addrList }" varStatus="i">
				<tr>
					<td><span>${i.count }</span><span style="font-size: 11;">${addr.location } ${addr.detail }</span></td>
					<td>${addr.significant }</td>
					<td align="right"><input onclick="document.location.href='${pc}/myPage/addr?addressType=${i.count}'" type = "button" value = "수정"><input onclick="document.location.href='${pc}/myPage/addr/delete?addressType=${i.count}'" type = "button" value="삭제"></td>				
				</tr>
			</c:forEach>
			<tr>
				<td align="right" colspan="3">
					<input type = "button" value="새로운 주소 추가" onclick="document.location.href='${pc}/myPage/addr'">
					<input type = "button" value="메인화면으로 이동" onclick="document.location.href='${pc}/'">
				</td>
			</tr>
		</table>
	</div>
</div>
<%@ include file="sideLayOut/footer.jsp" %>
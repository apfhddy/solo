<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<Map<String,Object>> orderList = (List<Map<String,Object>>)session.getAttribute("orderList");
	int sum = 0;
	if(orderList != null)
		for(Map<String,Object> oneMap : orderList){
			int cnt = (int)oneMap.get("cnt");
			int price = Integer.parseInt(String.valueOf(oneMap.get("PRICE"))); 		
			sum += price * cnt;
		}
	request.setAttribute("sum", sum);
%>
<%@ include file="../Layout/header.jsp" %>
<div align="left" style="margin-top: 1%;"> 
	<div style="margin-bottom: 2%;">
		주문 확인
	</div>
	<div style="display: flex;">
		<div style="width: 65%; background-color: white; margin-right: 0.5%; box-shadow: 0px 0px 2px gray; ">
			<form id = "orderForm" action="${pc }/order/pay" method="post">
				<div style=" padding-left: 3%; padding-top: 1.5%; padding-bottom: 1.5%; box-shadow: 0px 6px 5px rgb(0, 0, 0, 0.1); margin-bottom: 4%;">
					지불 유형을 선택하십시오
				</div>
				<div style="padding-left: 3%; padding-right: 3%; font-size: 11; vertical-align: center;">
					<div>
						<input id="1" type = "radio" name = "paymentType" checked="checked" style="margin-right: 1%;"><label for="1" >신용카드/간편결제/기타</label>
					</div>
					<hr>
					<div>현장 결제</div>
					<div>
						<input id="2" type = "radio" name = "paymentType" style="margin-right: 1%;"><label for="2" >현금</label>
					</div>
					<hr>
					<div>
						<input id="3" type = "radio" name = "paymentType" style="margin-right: 1%;"><label for="3" >5만원권</label>
					</div>
					<hr>
					<div>
						<input id="4" type = "radio" name = "paymentType" style="margin-right: 1%;"><label for="4" >수표</label>
					</div>
					<hr>
					<div>
						<input id="5" type = "radio" name = "paymentType" style="margin-right: 1%;"><label for="5" >카드</label>
					</div>
					<hr>
					<div>
						* 결제 완료하기 위해 외부 웹 사이트로 안전하게 이동합니다.
					</div>
				</div>
			</form>
		</div>
		<div style="padding-left:1%; padding-right:1%; width: 34%; background-color: white; margin-left: 0.5%; box-shadow: 0px 0px 2px gray; height: 100%;">
			<div style="padding-top: 2%;padding-bottom: 2%;" align="center">
				주문 요약
			</div>
			<div>
				배달 주소
			</div>
			<div>
				<table style="width: 100%; border-spacing: 0;">
						<tr>
							<td class="order-header">소액 주문비:</td>
							<td align="right">₩ ${sum  <= 15000 && sum != 0 ? 3000 : 0 }</td>
						</tr>
						<tr style="vertical-align: top; ">
							<td>총 주문합계:</td>
							<td align="right" style="font-size: 25; color: green;">₩ ${sum  <= 15000 && sum != 0 ? sum+3000 : sum}</td>
						</tr>
				</table>
			</div>
			<div>
				<p style="font-size: 9; color: gray">맥딜리버리 가격은 매장과 상이합니다.</p>
			</div>
			<div align="center">
				<input style="width: 100%; height: 40;" type = "button" value = "결제" onclick="orderForm.submit();">
			</div>
			<div align="center">
				<a style="font-size: 11;" onclick="history.back()">주문 재확인</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="../Layout/footer.jsp" %>
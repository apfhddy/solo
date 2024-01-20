<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Layout/header.jsp" %>
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
<div align="left" style="margin-top: 1%;"> 
	<div style="margin-bottom: 2%;">
		주문 확인
	</div>
	<div style="display: flex;">
		<div style="width: 65%; background-color: white; margin-right: 0.5%; box-shadow: 0px 0px 2px gray; ">
			<div style=" padding-left: 3%; padding-top: 1.5%; padding-bottom: 1.5%; box-shadow: 0px 6px 5px rgb(0, 0, 0, 0.1); margin-bottom: 4%;">
				내 주문 정보
			</div>
			<div style="padding-left: 3%; padding-right: 3%;">
				<c:forEach var="order" items="${orderList }">
					<div style="padding-top: 2%; padding-bottom: 2%;">
						<div style="display: flex; margin-bottom: 2%;">
							<div style="width: 5%; margin-left: 1%; margin-right: 1%;">
								${order.cnt }
							</div>
							<div style="width: 17%; margin-left: 1%; margin-right: 1%;">
								<img src = "${finalPath }/resources/buggerImg/${order.IMGPATH}" width="100%;">
							</div>
							<div style="margin-left: 1%; margin-right: 1%; width: 44%;">
								<div style="font-size: 14; margin-bottom: 1%;">
									${order.NAME }			
								</div>
								<div>
									<c:forEach var="name" items="${order.menuNames }">
										<div style="font-size: 9; color: gray">• ${name }</div>
									</c:forEach> 
								</div>
							</div>
							<div align="right" style="width: 30%; color: green">
								₩ ${order.PRICE * order.cnt }
							</div>		
						</div>
						<div style="display: flex;">
							<div>
								<input type = "button" value = "수정" onclick="updateForm(this)">
							</div>
							<div>
								<input type = "button" value = "삭제" onclick="del(this)">
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
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
				<input style="width: 100%; height: 40;" type = "button" value = "주문 확인" onclick="document.location.href=''">
			</div>
			<div align="center">
				<a style="font-size: 11;">항목 추가</a>
			</div>
		</div>
	</div>
</div>
<%@ include file="../Layout/footer.jsp" %>
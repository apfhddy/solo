<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">나의 주문 내역</div>
	<div style="background-color: white; box-shadow: 0px 0px 2px gray; padding: 2% 2% 2% 2%">
		<c:choose>
			<c:when test="${fn:length(orderList) != 0 }">
				<c:forEach var="mainOrder" items="${orderList }">
					<div style="margin-bottom: 2%; ">
						<div style="box-shadow: 0px 0px 2px gray; padding: 1% 1% 1% 1%;">
							<span style="margin-right: 2%;">
								<button style="width: 30px; background-color:red; " onclick="openDom(this)">
									<img src="${finalPath }/resources/img/bottom.png" width="100%" style=" filter: invert(100%) sepia(0%) saturate(0%) hue-rotate(93deg) brightness(103%) contrast(103%)">
								</button>
							</span>
							<span>
								주문 일자: <b>${mainOrder.ORDERDATE }</b>
							</span>
						</div>
						<div style="box-shadow: 0px 0px 2px gray; display: none;">
							<div style="display: flex;">
								<div style="width: 27%; padding: 2% 2% 2% 2%;">
									<div>
										<div style="color: gray;margin-top: 6%;margin-bottom: 1%;">
											주문 번호
										</div>
									</div>
									<div>
										<div style="color: gray;margin-top: 6%;margin-bottom: 1%;">
											주소
										</div>
										<div style="font-size: 13;">
											${mainOrder.ORDERADDRESS }
										</div>
									</div>
									<div>
										<div style="color: gray;margin-top: 6%;margin-bottom: 1%;">
											결제금액
										</div>
										<div>
											<table style="width: 100%;">
												<tr>
													<td style="color: gray; font-size: 11;">소액 주문비:</td>
													<td align="right">₩ <fmt:formatNumber  type="number" maxFractionDigits="3" value="${mainOrder.PAY  <= 15000 && mainOrder.PAY != 0 ? 3000 : 0 }"/></td>
												</tr>	
												<tr>
													<td>총 결제금액:</td>
													<td style="color: green;" align="right">₩ <fmt:formatNumber  type="number" maxFractionDigits="3" value="${mainOrder.PAY  <= 15000 && mainOrder.PAY != 0 ? mainOrder.PAY+3000 : mainOrder.PAY}"/></td>
												</tr>	
											</table>
										</div>
									</div>
								</div>
								<div style="width: 46%; border-left: 1px solid #D8D8D8; border-right: 1px solid #D8D8D8;">
									<c:forEach var="orders" items="${mainOrder.orders }">
										<div style="display: flex; padding: 4% 0 4% 0;">
											<div style="width: 5%;padding-left: 2%;">${orders.CNT }</div>
											<div style="width: 25%;">
												<img src="${finalPath }/resources/buggerImg/${orders.MAINIMG }" width="100%">
											</div>
											<div style="width: 70%;">
												<div>
													${orders.NAME }
												</div>
												<div>
													<c:if test="${orders.SETCHECK != 0 }">
														<c:forEach var="name" items="${orders.menuNames }">
															<div style="font-size: 11; color: gray">• ${name }</div>
														</c:forEach> 
													</c:if>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<div style="width: 27%; padding: 2% 2% 2% 2%;" align="center">
									<div>
										<input onclick="document.location.href='${pc}/orderList/repurchase?order_id=${mainOrder.ORDERTOTAL_NO }'" style="width: 100%; margin-bottom: 2%; height: 40px;" type ="button" value = "재주문">
									</div>
									<div>
										<!-- <input type ="button" value = "즐겨찾기 저장하기"> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				현재 주문 내역이 없습니다. <input type="button" value="주문 하기" onclick="document.location.href='${pc}/menu'">
			</c:otherwise>
		</c:choose>
	</div>
</div>
<script type="text/javascript">
	function openDom(t) {
		const target = t.parentElement.parentElement.parentElement.children[1];
		
		const tf = target.style.display == 'none';
		t.children[0].style.transform = tf ? "rotate(180deg)" : '';

		target.style.display = (tf ? '' : 'none');
	}
</script>
<%@ include file="sideLayOut/footer.jsp" %>
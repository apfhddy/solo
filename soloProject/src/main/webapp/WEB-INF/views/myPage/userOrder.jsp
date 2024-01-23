<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">나의 주문 내역</div>
	<div style="background-color: white; box-shadow: 0px 0px 2px gray; padding: 2% 2% 2% 2%">
		<c:forEach var="mainOrder" items="${orderList }">
			<div style="margin-bottom: 2%; ">
				<div style="box-shadow: 0px 0px 2px gray; padding: 1% 1% 1% 1%;">
					<span style="margin-right: 2%;">
						<button style="width: 30px; background-color:red; ">
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
								주문 번호
							</div>
							<div>
								주소 
							</div>
						</div>
						<div style="width: 46%; border-left: 1px solid #D8D8D8; border-right: 1px solid #D8D8D8;">
							<c:forEach var="orders" items="${mainOrder.orders }">
								<div style="display: flex; padding: 4% 0 4% 0;">
									<div style="width: 5%;padding-left: 2%;">${orders.CNT }</div>
									<div style="width: 25%;"><img src="${finalPath }/resources/buggerImg/${orders.MAINIMG }" width="100%"></div>
										<div>
										<div>
											${orders.NAME }
										</div>
										<div>
											<c:forEach var="name" items="${orders.menuNames }">
												<div style="font-size: 11; color: gray">• ${name }</div>
											</c:forEach> 
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
						<div style="width: 27%; padding: 2% 2% 2% 2%;" align="center">
							<div>
								<input style="width: 100%; margin-bottom: 2%; height: 40px;" type ="button" value = "재주문">
							</div>
							<div>
								<input type ="button" value = "즐겨찾기 저장하기">
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="sideLayOut/footer.jsp" %>
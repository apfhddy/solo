<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../Layout/header.jsp" %>
<% 
	List<Map<String,Object>> orderList = (List<Map<String,Object>>)session.getAttribute("orderList");
	int sum = 0;
	if(orderList != null)
		for(Map<String,Object> oneMap : orderList){
			int cnt = (int)oneMap.get("CNT");
			int price = (int)oneMap.get("PRICE"); 		
			sum += price * cnt;
		}
	request.setAttribute("sum", sum);
%>
<style>
	#menu-select{
		font-size: 12; 
		background-color: #FFC423;
		border-radius: 4px;
		width: 17%;
		margin-right: 0.5%;
		height: 100%;
	}
	
	#menu-select > div{
		padding: 6.3%; 
		cursor: pointer;
	}
	
	.menu-select-header{
		color: white;
		box-shadow: 0px 1px 2px rgb(0, 0, 0, 0.4);
		margin-bottom: 2%;
	}
	.menu-select-footer{
		color: black;
		margin-top: 1%;
		box-shadow: 0px -1px 2px rgb(0, 0, 0, 0.2);
	}

	.menu-select-items{
		border-top: 2px solid #FFCB3C;
		border-bottom: 2px solid #F7BD1E;
		border-bottom: 2px solid #F7BD1E;
		color: #A25716;
	}
	.menu-select-items:hover > span:nth-child(1){
		color: white;
	}
	.menu-select-items:hover > span:nth-child(2){
		color: red
	}
	
	.choice > span:nth-child(1){
		color: white;
	}
	.choice > span:nth-child(2){
		color: red
	}
	
	
	
	.menu-book-item{
		width: 48%; 
		margin-left: 1%; 
		margin-bottom:2%; 
		margin-right: 1%; 
		background-color: white;
		border-radius: 4px;
		box-shadow: 0px 0px 2px gray;
	}
	
	.menu-book-item-img{
		padding-top: 8%;
		padding-bottom: 4%; 
		box-shadow: 0px 4px 10px rgb(0, 0, 0, 0.06);
	}
	.menu-book-item-add{
	}
	
	.order-header{
		font-size: 11;
		color: gray; 
	}
	
	#order-body > div{ 
		border-top: 1px solid gray;
		padding-left: 2%; 
		padding-right: 2%;
		padding-top: 2%;
		padding-bottom: 2%; 
	}
	
</style>
<div align="left" style="margin-top: 1%; display: flex;">
	<div id = "menu-select">
		<div class="menu-select-header" onclick="document.location.href='?menuType_no=${menuTypeList[0].menuType_no}'">${menuTypeList[0].name }</div>
		<div class="menu-select-items ${choice == 1 ? 'choice' : '' }" onclick="document.location.href='?menuType_no=${menuTypeList[0].menuType_no}&cate_id=1'"><span>•</span> <span>추천 메뉴</span></div>	
		<c:forEach var="category" items="${categoryList}" varStatus="i">
			<div class="menu-select-items ${choice == (i.count+1) ? 'choice' : '' }" onclick="document.location.href='?menuType_no=${menuTypeList[0].menuType_no}&cate_id=${i.count+1}'"><span>•</span> <span>${category.name }</span></div>	
		</c:forEach>
		<c:forEach var="i" begin="1" end="${fn:length(menuTypeList)-1 }">
			<div class="menu-select-footer" onclick="document.location.href='?menuType_no=${menuTypeList[i].menuType_no}'">${menuTypeList[i].name }</div>
		</c:forEach>
	</div>
	<div style=" width: 83%;">
		<div style="font-size: 10px; margin-bottom: 1%;">메뉴 ➡️ 추천메뉴</div>
		<div style="display: flex;">
			<div style="width: 67%; ">
				<div style="display: flex; flex-wrap: wrap;">
					<!-- 메뉴 하나 css -->
				 	<c:forEach var="goods" items="${goodsList }">
						<div class="menu-book-item">
							<div align="center" class="menu-book-item-img">
								<div><img src="${finalPath }/resources/buggerImg/${goods.MAINIMG}" width="70%"></div>
								<div style="font-size: 12;">${goods.NAME }</div>
							</div>
							<div style="margin-top: 2%; padding-left: 4%; padding-bottom: 4%;">
								<div style="width: 100%; display: flex; ">
									<div style="width: 48%; font-size: 11;"> 
										<div style="color:green">가격 ₩ <fmt:formatNumber  type="number" maxFractionDigits="3" value="${goods.PRICE}"/></div>
										<div>${goods.CALORIE} Kcal</div>
										<div>알레르기 원산지</div>
									</div>
									<div align="center" style="width: 48%;"> 
										<input data-token="${goods.GOODS_NO}" class="menu-book-item-add" onclick="document.location.href='#add/${goods.GOODS_NO}'" type="button" value = "추가" style="width: 90%;">
									</div>
								</div>
							</div>				
						</div>
					</c:forEach> 
					<!-- / -->
				</div>  <!-- css 가 깨짐 메뉴 헤더와 푸터 수정후 바디와 분리  -->
			</div>
			<div id = "order-body" style="width: 31%; margin-left: 0.5%;	 background-color: white;height: 100%; box-shadow: 0px 0px 2px gray;">
				<c:choose>
					<c:when test="${mainAddr != null }">
						<div align="center">내 주문 정보</div>
						<div style="display: flex; ">
							<div style="width: 40%;">
								<div class="order-header">배달 주소 :</div>
								<div><a style="color: blue;font-size: 12;">변경</a></div>
							</div>
							<div style="width: 60%; font-size: 11;">
								${mainAddr.location } ${mainAddr.detail }
							</div>
						</div>
						<div>
							<table style="width: 100%; border-spacing: 0;">
								<tr>
									<td class="order-header">소액 주문비:</td>
									<td align="right">₩ <fmt:formatNumber  type="number" maxFractionDigits="3" value="${sum  <= 15000 && sum != 0 ? 3000 : 0 }"/></td>
								</tr>
								<tr style="vertical-align: top; ">
									<td>총 주문합계:</td>
									<td align="right" style="font-size: 25; color: green;">₩ <fmt:formatNumber  type="number" maxFractionDigits="3" value="${sum  <= 15000 && sum != 0 ? sum+3000 : sum}"/></td>
								</tr>
								<tr>
									<th colspan="2"><input ${orderList == null ? 'disabled' : '' }  style="width: 100%; height: 35; " type = "button" value="결제" onclick="document.location.href='${pc}/order/check'"></th>
								</tr>
							</table>
						</div>
						<div>
							<a>쿠폰코드 입력하기</a>
						</div>
						<div>
							<div>
								주문 세부사항	
							</div>
							<div id = "orderItems">
								<c:forEach var="order" items="${orderList }">
									<div>
										<div style="display: flex; margin-top: 2%; margin-bottom: 10%;">
											<div style="width: 6%; margin-left: 2%;margin-right: 2%;" align="center">${order.CNT }</div>
											<div style="width: 26%; margin-left: 2%;margin-right: 2%;"><img src="${finalPath }/resources/buggerImg/${order.IMGPATH}" width="100%"></div>
											<div style="width: 56%; margin-left: 2%;margin-right: 2%;">
												<div>
													<div style="font-size: 11;">
														${order.NAME }			
													</div>
													<div>
														<c:forEach var="name" items="${order.menuNames }">
															<div style="font-size: 9; color: gray">• ${name }</div>
														</c:forEach> 
													</div>
												</div>
											</div>
										</div>
										<div style="display: flex;">
											<div>
												<input type = "button" value = "수정" onclick="updateForm(this)">
											</div>
											<div>
												<input type = "button" value = "삭제" onclick="del(this)">
											</div>
											<div align="right" style="width: 100%; color: green">
												₩ <fmt:formatNumber  type="number" maxFractionDigits="3" value="${order.PRICE * order.CNT }"/>
											</div>								
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<img src="${finalPath }/resources/img/side.png" width="100%;">
					</c:otherwise>
				</c:choose>
			</div>	
		</div>	
	</div>
</div>
<script type="text/javascript">
	const items = Array.from(document.querySelectorAll(".menu-book-item-add"));
	let token = null;
	
	
	let setMap = null;
	let tableList = null;
	if(${login != null ? 1 : 1}){
		items.forEach( i => {
			i.addEventListener("click", function() {
				url = "${pc}/orderList";
				token = this.getAttribute("data-token");
				const data = this.parentElement.parentElement.parentElement.parentElement.children[0];
				const name = data.children[1].innerText;
				const img = data.children[0].children[0].src;
				detailPopData(token,img,name);
			})
		})
	}
	
	function updateForm(t){
		const index = orderIndex(t);
		url = "${pc}/orderList?v="+index;
		$.ajax({
			url:"${pc}/order/updateForm",
			data:{v:index},
			type:"post",
			success: (result) =>{
				detailPopData(result['GOODS_NO'],'${finalPath }/resources/buggerImg/'+result['IMGPATH'],result['NAME'],result);
			}
		})
	}
	function del(t){
		const index = orderIndex(t);
		console.log(index);
		$.ajax({
			url:"${pc}/order/delete",
			data:{v:index},
			type:"post",
			success: (result) =>{
				document.location.href='<%=(String)request.getAttribute("javax.servlet.forward.request_uri")+"?"+"menuType_no="+request.getParameter("menuType_no")+"&cate_id="+request.getParameter("cate_id")%>'
			}
		}) 
	}
	
	function orderIndex(target){
		for(let i = 0; i < orderItems.children.length; i++){
			if(orderItems.children[i] == target.parentElement.parentElement.parentElement){
				return i;
			}
		}
		return -1;
	}
	
	
	function detailPopData(token,img,name,target){
		detailPopNum.innerText = 0;
		detailPopImg.src = img;
		detailPopName.innerText = name;
		orderBody.innerHTML = '';
		domMap = {};
		$.ajax({
			url:"${pc}/getItemDetail",
			data:{v:token},
			type:"post",
			success: function (result) {
				
				tableList = result['tableList']; 
				setMap = result['setMap']; 
				
				const tbody = detailPopTable.children[0];
				const tableCArr = Array.from(tbody.children);
				tableCArr.shift();
				tableCArr.forEach( tr => {
					tbody.removeChild(tr);
				})
				
				let targetTd;
				
				tableList.forEach( t => {
					
					domMap[t['GOODSDETAIL_NO']] = []; 					
					
					const newTr = document.createElement("tr");
					newTr.className = "detailPop-table-tr";
					
					const newTd1 = document.createElement("td");
					newTd1.innerHTML = '<button type="button" onclick="fnCalCount(1, this);">-</button><input  type="text"   name="pop_out" value="0" readonly="readonly" style="text-align:center; width: 30%;"/><button type="button" onclick="fnCalCount(2, this);">+</button>';
					
					if(target != null && t['GOODSDETAIL_NO'] == target['MAINNO']){
						targetTd = newTd1.children[2];
					}
					
					
					
					const newTd2 = document.createElement("td");
					newTd2.innerHTML = '<img src="${finalPath }/resources/buggerImg/'+t['IMGPATH']+'" width="100%">';
					
					const newTd3 = document.createElement("td");
					newTd3.innerText = t['NAME'];
					
					const newTd4 = document.createElement("td");
					newTd4.innerText = '₩ '+t['PRICE'];
					
					const newTd5 = document.createElement("td");
					newTd5.innerText = t['CALORIE'] +" Kcal";
					
					newTr.appendChild(newTd1);
					newTr.appendChild(newTd2);
					newTr.appendChild(newTd3);
					newTr.appendChild(newTd4);
					newTr.appendChild(newTd5);
					tbody.appendChild(newTr);
					
					
				})
				if(target != null)
					for(let i = 0; i < +target['CNT']; i++){
						targetTd.click()
					} 
				pop(detailPop);
			}
		});
	}
	
</script>
<%@ include file="../Layout/footer.jsp" %>
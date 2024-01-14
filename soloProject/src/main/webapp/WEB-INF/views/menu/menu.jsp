<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="../Layout/header.jsp" %>
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
		color: #FF4F20
	}
	.menu-select-items:hover > span:nth-child(2){
		color: red
	}
	
	.choice > span:nth-child(1){
		color: #FF4F20
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
	}
	
	.menu-book-item-img{
		padding-top: 8%;
		padding-bottom: 4%; 
		box-shadow: 0px 4px 10px rgb(0, 0, 0, 0.06);
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
	<div style=" width: 100%;">
		<div style="font-size: 10px; margin-bottom: 1%;">메뉴 ➡️ 추천메뉴</div>
		<div style="display: flex;">
			<div style="width: 67%; ">
				<div style="display: flex; flex-wrap: wrap;">
					<!-- 메뉴 하나 css -->
					<c:forEach var="goods" items="${goodsList }">
						<div class="menu-book-item">
							<div align="center" class="menu-book-item-img">
								<div><img src="${finalPath }/resources/buggerImg/${goods.IMGPATH}" width="70%"></div>
								<div style="font-size: 12;">${goods.NAME }</div>
							</div>
							<div style="margin-top: 2%; padding-left: 4%; padding-bottom: 4%;">
								<div style="width: 100%; display: flex; ">
									<div style="width: 50%; font-size: 10;"> 
										<div>가격 ₩ ${goods.PRICE}</div>
										<div>${goods.CALORIE} Kcal</div>
										<div>알레르기 원산지</div>
									</div>
									<div align="center" style="width: 50%;"> 
										<input type="button" value = "추가" style="width: 90%;">
									</div>
								</div>
							</div>				
						</div>
					</c:forEach>
					<!-- / -->
				</div>
			</div>	
			<div style="width: 33%; margin-left: 0.5%;	 background-color: white; padding-left: 1%; height: 100%;">
				<div align="center">내 주문 정보</div>
				<div style="display: flex; ">
					<div style="width: 40%;">
						<div>배달 주소 :</div>
						<div><a>변경</a></div>
					</div>
					<div style="width: 60%;">
					</div>
				</div>
				<div>
					소액 주문비
				</div>
			</div>	
		</div>	
	</div>
</div>
<script type="text/javascript">
	const menuList = Array.from(document.querySelectorAll(".menu-select-items"));
	menuList.forEach( m => {
	});
	
	
</script>
<%@ include file="../Layout/footer.jsp" %>
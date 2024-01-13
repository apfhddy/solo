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
		cursor: pointer;
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
		<div class="menu-select-header">${menuTypeList[0].name }</div>
		<div class="menu-select-items">• 추천 메뉴</div>	
		<c:forEach begin="0" end="5" varStatus="i">
			<div class="menu-select-items">• ${i.count+1 }</div>	
		</c:forEach>
		<c:forEach var="i" begin="1" end="${fn:length(menuTypeList)-1 }">
			<div class="menu-select-footer">${menuTypeList[i].name }</div>
		</c:forEach>
	</div>
	<div style=" width: 100%;">
		<div style="font-size: 10px; margin-bottom: 1%;">메뉴 ➡️ 추천메뉴</div>
		<div style="display: flex;">
			<div style="width: 67%; ">
				<div style="display: flex; flex-wrap: wrap; ">
					<!-- 시작 -->
					<div class="menu-book-item">
						<div align="center" class="menu-book-item-img">
							<div><img src="${finalPath }/resources/buggerImg/bugger.png" width="70%"></div>
							<div style="font-size: 12;">정인내 병신년</div>
						</div>
						<div style="margin-top: 2%; padding-left: 4%; padding-bottom: 4%;">
							<div style="width: 100%; display: flex; ">
								<div style="width: 50%; font-size: 10;"> 
									<div>가격 ₩</div>
									<div>1048 Kcal</div>
									<div>알레르기 원산지</div>
								</div>
								<div align="center" style="width: 50%;"> 
									<input type="button" value = "추가" style="width: 90%;">
								</div>
							</div>
						</div>				
					</div>
					<!-- /시작 -->
					<%-- <div style="width: 48%; margin-left: 1%; margin-bottom:2%; margin-right: 1%; background-color: white;">
						<div align="center" style="padding-top: 8%;padding-bottom: 4%; box-shadow: 0px 4px 10px rgb(0, 0, 0, 0.06);">
							<div><img src="${finalPath }/resources/buggerImg/bugger.png" width="70%"></div>
							<div style="font-size: 12;">울도히 안녕</div>
						</div>
						<div style="margin-top: 2%; padding-left: 4%; padding-bottom: 4%;">
							<div style="width: 100%; display: flex; ">
								<div style="width: 50%; font-size: 10;"> 
									<div>가격 ₩</div>
									<div>1048 Kcal</div>
									<div>알레르기 원산지</div>
								</div>
								<div align="center" style="width: 50%;"> 
									<input type="button" value = "추가" style="width: 90%;">
								</div>
							</div>
						</div>				
					</div> --%>
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
<%@ include file="../Layout/footer.jsp" %>
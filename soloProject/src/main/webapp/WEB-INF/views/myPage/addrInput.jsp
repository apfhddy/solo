<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="sideLayOut/header.jsp" %>
<style>
	.joinBody{
		width: 100%;height: 600px; 
		background-color: white; 
		padding-top: 3%;
	}
	.joinBody-table{
		width: 70%; 
		margin-top: 3%;
	}
	.joinBody-table-input{
		width: 100%;
		height: 37px; 
		font-size: 16; 
		padding-left: 11px;
	}
	.joinBody-table-button{
		width: 80%;
		height: 37px;
	}
	.joinBody-table-result{
		margin-top: 0.3%; 
		position: absolute; 
		border: 1px solid; 
		background-color: white; 
		width: 18%;
		border-radius: 2px; 
		height: 300px;
		overflow-y: scroll;
	}
	#resultTable{
		width: 100%;
		border-collapse: collapse;
	}
	.td1 {
		width: 85%;
		font-size: 11;
		border-bottom: 1px solid gray;
	}
	.td2 {
		width: 15%;
		border-bottom: 1px solid gray;
	}
</style>
<div style="flex-wrap: nowrap; width: 85%;">
	<div class="menu-header">주소 <%=request.getParameter("addressType") != null ? "수정하기" : "추가하기"%></div>
	<div class="joinBody" align="center">
		<div>
			<img src="${finalPath }/resources/img/join1.gif" width="76%">
		</div>
		<div>
			<form action="${pc }/myPage/addr/<%=request.getParameter("addressType") != null ? "update" : "add"%>" method="post">
				<table class="joinBody-table">
					<tr>
						<td>지역명</td>
						<td>
							<input class="joinBody-table-input" id = "inAddr" placeholder="지번,도로명,건물명으로 검색해주세요">
							<div class="joinBody-table-result" style="display: none;">
								<table id="resultTable" >
								</table>
							</div>
						</td>
						<td>
							<input onclick="searchAddr()" class="joinBody-table-button" type = "button" value = "검색">
						</td>
					</tr> 
					<tr>
						<td>상세주소</td>
						<td>
							<input name = "detail" class="joinBody-table-input" placeholder="나머지 주소를 입력해 주세요">
						</td>
					</tr>
					<tr>
						<td>최종 배달주소</td>
						<td style="font-weight: bold;font-size: 15;">sfdasfsafadsf
						</td>
					</tr>
					<tr>
						<td>배달 특이사항</td>
						<td>
							<input name = "significant" class="joinBody-table-input" placeholder="예) 아이가 있으니 노크해 주세요">
						</td>
					</tr>
				</table>
				<c:if test="<%=request.getParameter(\"addressType\") != null %>">
					<input type = "hidden" name="addressType" value = "<%=request.getParameter("addressType")%>">
				</c:if>
			</form>
		</div>
		<input onclick="checkForm()" type = "button" value="주소 <%=request.getParameter("addressType") != null ? "수정하기" : "추가하기"%>">
		<input onclick="history.back()" type = "button" value="뒤로 가기">
	</div>
</div>
<%@ include file="sideLayOut/footer.jsp" %>
<script type="text/javascript">
	let jiuck = null;
	function searchAddr(){
		
		let v = inAddr.value
		
		function addrErr(errMessage){
			resultTable.innerHTML = "";
			const newTr = document.createElement("tr");
			const newTd = document.createElement("td");
			newTd.innerText = errMessage;
			newTr.appendChild(newTd);
			resultTable.appendChild(newTr);
			document.querySelector(".joinBody-table-result").style.display = "";
		}
		
		if(v == "")return addrErr(errMessage['011']);
		const fMap = checkSearchedWord(v);
		if(fMap['err'])return addrErr(errMessage[fMap['code']]);
	
		
		$.ajax({
			url:"${pc}/searchAddr",
			type:"post",
			data:{str:v},
			success: function(answer){
				const check = resultCheck(answer);
				if(check["err"] == 1){
					addrErr(errMessage[check["code"]]);
				}
				document.querySelector(".joinBody-table-result").style.display = "";
			}
		});
	}
	
	function resultCheck(answer){
		if(answer["err"] == 1){
			return {err: 1 , code:'014'};
		}
		
		const result = JSON.parse(answer["result"]);
		const err = result["results"]["common"];
		
		if(err["errorCode"] != 0){
			return {err: 1 , str : err["errorMessage"]};
		}
		
		const resultArray = result["results"]["juso"];
		
		if(resultArray.length == 0){
			return {err: 1 , code:'014'};
		}
		
		resultTable.innerHTML = "";
		resultArray.forEach( r => {
			const newTr = document.createElement("tr");
			const newTd1 = document.createElement("td");
			const newTd2 = document.createElement("td");
			const newBt = document.createElement("input");
			
			function btEt() {
				document.querySelector(".joinBody-table-result").style.display = "none";
				jiuck = this.parentElement.parentElement.children[0].innerText;
			}
			
			newTd1.innerText = r["roadAddr"]+" 지번: "+r["lnbrMnnm"]+"-"+r["lnbrSlno"];
			newBt.setAttribute("type", "button");
			newBt.setAttribute("value", "선택");
			newBt.addEventListener("click",btEt);
			newTd2.appendChild(newBt);
			
			newTd1.className = "td1";
			newTd2.className = "td2";
			
			newTr.appendChild(newTd1);
			newTr.appendChild(newTd2);
			resultTable.appendChild(newTr);
		});
		return {err : 0};
	}
	
	function checkForm() {
		const form = document.querySelector(".joinBody").querySelector("form");
		const newIp = document.createElement("input");
		newIp.setAttribute("name","location" );
		newIp.setAttribute("value", jiuck);
		newIp.setAttribute("type", "hidden");
		form.appendChild(newIp);
		form.submit();
	}
	
	function checkSearchedWord(obj){
		if(obj.length >0){
		//특수문자 제거
			var expText = /[%=><]/ ;
			if(expText.test(obj) == true){
				return {err:true,code:'012'};
			}
			
			//특정문자열(sql예약어의 앞뒤공백포함) 제거
			var sqlArray = new Array(
			//sql 예약어
			"OR", "SELECT", "INSERT", "DELETE", "UPDATE"
			,"CREATE", "DROP", "EXEC", "UNION"
			,"FETCH", "DECLARE", "TRUNCATE" );
			 
			var regex;
			for(var i=0; i<sqlArray.length; i++){
				regex = new RegExp( sqlArray[i] ,"gi") ;
			
				if (regex.test(obj) ) {
					return {err:true,code:'013'};
				}
			}
		}
		return {err:false} ;
	}
</script>
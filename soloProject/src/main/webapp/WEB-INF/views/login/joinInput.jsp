<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Layout/header.jsp" %>
<style>
	.guide{
		font-size: 12;
		margin-top: 0.5%;
		margin-bottom: 0.5%;
	}
	.guide-hr{
		border-top: 1px dashed #bbb;
	}
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
<div class="guide">
	배달 받을 주소를 입력하시면 예상 배달 시간을 확인 할 수 있습니다.
</div>
<hr class="guide-hr">
<div class="joinBody">
	<div>
		<img src="${pc }/resources/img/join1.gif" width="76%">
	</div>
	<div>
		<form>
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
					<input name = "location" onclick="searchAddr()" class="joinBody-table-button" type = "button" value = "검색">
				</td>
			</tr> 
			<tr>
				<td>상세주소</td>
				<td>
					<input name = "detail" class="joinBody-table-input" placeholder="나머지 주소를 입력해 주세요">
				</td>
			</tr>
			<tr>
				<td>배달 특이사항</td>
				<td>
					<input name = "significant" class="joinBody-table-input" placeholder="예) 아이가 있으니 노크해 주세요">
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
<input type = "button" value="확인">
<script type="text/javascript">
	let jiuck = null;
	function searchAddr(){
		$.ajax({
			url:"${pc}/searchAddr",
			type:"post",
			data:{str:inAddr.value},
			success: function(answer){
				
				const check = resultCheck(answer);
				if(check["err"] == 1){
					resultTable.innerHTML = "";
					const newTr = document.createElement("tr");
					const newTd = document.createElement("td");
					newTd.innerText = check["str"];
					newTr.appendChild(newTd);
					resultTable.appendChild(newTr);
				}
				document.querySelector(".joinBody-table-result").style.display = "";
			}
		});
	}
	
	function resultCheck(answer){
		const result = JSON.parse(answer["result"]);
		const err = result["results"]["common"];
		
		if(err["errorCode"] != 0){
			return {err: 1 , str : err["errorMessage"]};
		}
		
		const resultArray = result["results"]["juso"];
		
		if(answer["err"] == 1 || resultArray.length == 0){
			return {err: 1 , str : "해당하는 건물 정보가 없습니다."};
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
</script>
<%@ include file="../Layout/footer.jsp" %>
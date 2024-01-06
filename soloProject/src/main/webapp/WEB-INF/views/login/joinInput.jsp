<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../Layout/header.jsp" %>
<div style="font-size: 12; margin-top: 0.5%;margin-bottom: 0.5%;">
	배달 받을 주소를 입력하시면 예상 배달 시간을 확인 할 수 있습니다.
</div>
<hr style=" border-top: 1px dashed #bbb;">
<div style="width: 100%;height: 600px; background-color: white; padding-top: 3%;">
	<div>
		<img src="${pc }/resources/img/join1.gif" width="76%">
	</div>
	<div>
		<table style="width: 60%; margin-top: 3%;">
			<tr>
				<td>지역명</td>
				<td><input id = "inAddr" style="width: 95%;height: 37px; font-size: 16; padding-left: 11px;" placeholder="지번,도로명,건물명으로 검색해주세요"></td> 
				<td><input style="width: 80%;height: 37px;" type = "button" value = "검색"></td>
			</tr> 
		</table>
	</div>
</div>
<script type="text/javascript">
	function searchAddr(){
		$.ajax({
			url:"${pc}/searchAddr",
			type:"post",
			data:{str:inAddr.value},
			success: (answer){
				console.log(answer);
			}
		});
		
	}
</script>
<%@ include file="../Layout/footer.jsp" %>
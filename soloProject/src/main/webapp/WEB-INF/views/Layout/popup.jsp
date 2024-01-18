<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id = "popUp" style="display: none; ">
	<div id = "detailPop" style="display: none;">
		<div class="detailPop-header">
			<div style="width: 45.8%; display: flex; padding-top: 0.5%;" align="left">
				<div align="center" style="margin-left: 1%; margin-right: 1%; width: 3%;">
					<div id="detailPopNum" style="font-size: 40; color: red">0</div>
					<div style="font-size: 11;">수량</div>
				</div>
				<div  style="margin-left: 1%; margin-right: 1%; padding-top: 1%; width: 14%;" align="center">
					<img id = "detailPopImg" src="" width="100%">
				</div>
				<div id = "detailPopName" style="margin-left: 1%; margin-right: 1%; font-size: 24;">
				</div>
				<div style="width: 3%; margin-left: auto; cursor: pointer;">
					<img src="${finalPath }/resources/img/x.png;" width="100%" onclick="pop(detailPop,'del')">
				</div>
			</div>
		</div>
		<div class="detailPop-body" align="left">
			<div>
				<table id ="detailPopTable">
					<tr style="font-size: 14; color: gray;">
						<td colspan="3">1단계: 메뉴를 선택하세요</td>
						<td align="right">가격</td>
						<td align="right">KCAL</td> 
					</tr> 
				</table>
			</div>
			<hr style="border: 1px solid gray; ,margin-bottom: 1%;">
			<div style="font-size: 14; color: gray; margin-bottom: 1%;">
				2 단계: 메뉴 항목을 선택하세요
			</div>
			<div id = "orderBody">
				
			</div>
			<hr style="border: 1px solid gray;">
		</div>
		<div class="detailPop-footer" >
			<div style="width: 45.8%;" align="left">
				<input type = "button" value="메뉴로 돌아가기" onclick="pop(detailPop,'del')">
				<input type = "button" value="카트에 추가하기" onclick="addCart()">
			</div>
		</div>
	</div>
	<div id = "loginPop" style="display: none;">
		<div id = "loginPop-logo">
			<img src="${finalPath }/resources/img/logo.jpg" width="108px">
		</div>
		<div>
			주문을 하시려면 	로그인하시기 바랍니다.
			<div>
				<form action="${pc }/login" onkeypress="if(event.keyCode == 13)login(this,loginPopErr)">
					<table style="width: 40%;">
						<tr>
							<td style="width: 50%; border-right: 1px solid; text-align: center;">로그인</td>
							<td style="width: 50%; text-align: center;">비회원주문</td> 
						</tr>
						<tr>
							<td colspan="2">
								<input name = "id" class="login-input" placeholder="아이디">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<input name = "pw" type = "password" class="login-input" placeholder="비밀번호">
							</td>
						</tr>
						<tr>
							<td id="loginPopErr" style="font-size: 10; color: red;" colspan="2"></td>
						</tr>
						<tr>
							<th colspan="2"><input onclick="login(this.form,loginPopErr)" class="login-button" type = "button" value = "로그인"></th>
						</tr>
						<tr>
							<td colspan="2" align="right" style="font-size: 11;"><a>비밀번호 찾기</a></td>
						</tr>
						<tr>
							<th colspan="2"><input onclick="document.location.href='${pc}/join/addr'" class="login-button" type = "button" value = "회원가입"></th>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	let domMap;
	function pop(target,t){
		if(t == 'del'){
			document.removeEventListener("mousedown",popRemove);
			popUp.style.display = 'none';
			target.style.display = 'none';
			return
		}
		target.style.display = '';
		popUp.style.display = '';
		function popRemove(e){
			if(!target.contains(e.target)){
				document.removeEventListener("mousedown",popRemove);
				popUp.style.display = 'none';
				target.style.display = 'none';
			}
		}
		document.addEventListener("mousedown", popRemove);
	}

	function login_Pop() {
		pop(loginPop);
	}
	
	
	
	function addCart(){
		
		resultObject = {}
		
		Object.keys(domMap).forEach( key => {
			if(domMap[key].length != 0){
				if(resultObject[key] == null) resultObject[key] = [];
				domMap[key].forEach( d => {
					let pusyArr = []; 
					if(d.children[1].children.length != 0)
						Array.from(d.children[1].children).forEach( dc1 => {
							pusyArr.push({no:dc1.getAttribute("data-id"),name:dc1.innerText});
						}) 
					if(d.children[2] != null && d.children[2].children.length != 0)
						Array.from(d.children[2].children).forEach( dc2 => {
							pusyArr.push({no:dc2.getAttribute("data-id"),name:dc2.innerText});
						})
					resultObject[key].push(pusyArr);
				
				})
			} 
		})
		$.ajax({
			url:"${pc}/test", 
			data:{json:JSON.stringify(resultObject)}, 
			type:"post",
			success: document.location.href='<%=(String)request.getAttribute("javax.servlet.forward.request_uri")+"?"+"menuType_no="+request.getParameter("menuType_no")+"&cate_id="+request.getParameter("cate_id")%>'	
		})
		
	}
	
	
	
	
	function fnCalCount(type,t){
		const tf = type == 2;
		
		const v1 = +t.parentElement.children[1].value;
		if(v1 == 0 && !tf)return
		if(v1 == 10 && tf) return;
		const value = tf ? 1 : -1;
		t.parentElement.children[1].value = v1 + value;
		
		const v2 = +detailPopNum.innerText;
		detailPopNum.innerText = v2 + value;
		
				
		let index = 0;
		
		let childList = Array.from(detailPopTable.children[0].children);
		
		for(let i = 0; i < childList.length; i++){
			if(childList[i] == t.parentElement.parentElement){
				index = i-1;
				break;
			}
		}
			
		const targetDetail = tableList[index];
		if(value == 1){
			const mDv = document.createElement('div');
			mDv.style.display = 'flex';
			mDv.style.borderTop = '1px solid gray';
			mDv.style.paddingTop = '0.7%';
			mDv.style.paddingBottom = '0.7%';
			
			const pDv1 = document.createElement('div');
			const pDv2 = document.createElement('div');

			pDv1.style.width = '25%';
			pDv1.style.fontSize = '15';
			pDv1.innerHTML = '<img src="${finalPath }/resources/img/x.png;" style = "margin-right: 2%;margin-left: 2%; cursor: pointer;"  width="5%" onclick="pop(detailPop,"del")">'+ targetDetail['NAME'];;
			
			mDv.appendChild(pDv1);
			mDv.appendChild(pDv2);
			if (targetDetail['SETCHECK'] != 1){
				pDv2.innerHTML = '<div data-id="'+targetDetail['GOODSDETAIL_NO']+'"></div>';
			}
			else{
				const pDv3 = document.createElement('div');
				
				
		
				pDv2.style.width = '25%';
				pDv2.style.fontSize = '11';
		
				pDv3.style.width = '25%';
				pDv3.style.fontSize = '11';
				
				
				const setArr = setMap[targetDetail['GOODSDETAIL_NO']];
				setArr.forEach( s => {
					const newDv = document.createElement('div');
					newDv.innerText = '• '+s['NAME']+' - '+s['SIZENAME'];
					newDv.setAttribute("data-id", s['PARTS_NO']);
					if(s['PARTSCHANGE_NO'] != 1){
						pDv2.appendChild(newDv);
					}else{
						pDv3.appendChild(newDv);
					}
				})
				mDv.appendChild(pDv3);
			}
			domMap[targetDetail['GOODSDETAIL_NO']].push(mDv);
			orderBody.appendChild(mDv);
		}else{
			orderBody.removeChild(domMap[targetDetail['GOODSDETAIL_NO']].pop());
		}
		
	}

</script>
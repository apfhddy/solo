<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	</div>
	<div>
	</div>
</div>
<script type="text/javascript">
	let email_pt = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
	let pw_pt = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/;
	let phone_pt = /^[0-9]{3}[0-9]{4}[0-9]{4}$/;
	

	
	
	function login(t,target){
		let id = t.id.value.trim();
		let pw = t.pw.value.trim();
				
		function err(errCode){
			target.innerText = errMessage[errCode];
		}
		
		if(id == "")return err('001');
		if(!email_pt.test(id))return err('002');
		if(pw == "")return err('004')

		
		$.ajax({
			url:"${pc}/check/login",
			data:{id: id,pw:pw},
			type:"post",
			success: function(result) {
				if(result['err'])return err(result['code']);
				t.submit();
			}
		}) 
		
	}
	
	const errMessage = 
	{
		'000':"",
		'001':"이메일 주소를 입력하셔야 합니다",
		'002':"잘못된 이메일 주소입니다",
		'003':"이메일 또는 비밀번호가 일치하지 않습니다",
		'004':"비밀번호를 입력하셔야 합니다",
		'011':"검색어가 입력되지 않았습니다",
		'012':"특수문자를 입력 할수 없습니다",
		'013':"검색할 수 없는 검색어 입니다",
		'014':"해당하는 건물 정보가 없습니다",
		'021':"이름을 입력해주세요",
		'022':"핸드폰번호를 입력하셔야 합니다",
		'023':"핸드폰번호는 - 를 제외한 11자리여야 합니다",
		'024':"이메일 주소를 확인하세요",
		'025':"확인 이메일 주소를 확인하세요",
		'026':"이메일이 일치하지 않습니다",
		'027':"확인 비밀번호를 입력하셔야 합니다",
		'028':"비밀번호는 영문 숫자 조합 8자리 이상이여야 합니다",
		'029':"확인 비밀번호는 영문 숫자 조합 8자리 이상이여야 합니다",
		'030':"비밀번호가 일치하지 않습니다",
		'031':"이미 존재하는 이메일입니다",
		'032':"이미 존재하는 휴대폰번호입니다",
		'033':"휴대폰번호를 올바르게 입력해주세요",		
		'041':"기존 비밀번호를 입력하셔야 합니다"		
	}
	
	
</script>
</body>
</html>
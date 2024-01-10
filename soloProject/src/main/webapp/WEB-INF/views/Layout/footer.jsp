<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	</div>
	<div>
	</div>
</div>
<script type="text/javascript">
	let email_pt = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;

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
		'004':"비밀번호를 입력하셔야 합니다"
	}
	
	
</script>
</body>
</html>
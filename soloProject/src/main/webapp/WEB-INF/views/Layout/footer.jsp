<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	</div>
	<div>
	</div>
</div>
<script type="text/javascript">
	function login(t){
		let id = t.id.value;
		let pw = t.pw.value;
		
		const errMessage = 
		{
			001:"",
			002:""
		}
		$.ajax({
			url:"${pc}/login/check",
			data:{id: id,pw:pw},
			type:"post",
			success: function(code) {
				if(code == "777"){
					document.location.href = '${pc}/'
				}
			}
		})
	}
	
	function myPageMenu() {
		
	}
</script>
</body>
</html>
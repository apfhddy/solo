<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	</div>
	<div>
	</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">

	function pop(target){
		popUp.style.display = '';
		
		function popRemove(e){
			if(!target.contains(e.target)){
				popUp.removeEventListener("mousedown",popRemove);
				popUp.style.display = 'none';
			}
		}
		docu
		popUp.addEventListener("mousedown", popRemove);
	}

	function login_Pop() {
		pop(loginPop);
	}

</script>
</body>
</html>
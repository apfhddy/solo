<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input id = "a"><input type = "button" onclick="getAddrLoc(a.value)">
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	
	function getAddrLoc(addr){
     // 적용예 (api 호출 전에 검색어 체크) 
    	if (!checkSearchedWord(addr)){ return ; }
      		$.ajax({
      		url : "https://business.juso.go.kr/addrlink/addrLinkApi.do?confmKey=devU01TX0FVVEgyMDI0MDEwNDE1MzI0NTExNDQwNjU=&resultType=json&keyword="+addr
      		,type:"get"
      		,success:function(xmlStr){
      			let xmlData = null;
      			if(navigator.appName.indexOf("Microsoft") > -1 ){
	     			//IE 환경에서 JSONP의 returnXml 결과데이터처리
	     			xmlData = newActiveXObject("Microsoft.XMLDOM");
	     			xmlData.loadXML(xmlStr.returnXml)
	     		}else{
	      			//IE 이외 환경에서 처리
	      			xmlData= xmlStr.returnXml;
	     		}
	     		$("#list").html("");
	     		var errCode = $(xmlData).find("errorCode").text();
	     		console.log(errCode)
	     		var errDesc = $(xmlData).find("errorMessage").text();
	     		if(errCode != "0" && errCode != ""){
	      			alert(errCode+"="+errDesc);
	     		}else{
	      			if(xmlStr!= null){
	      				makeList(xmlData);
	      			}
	     		} 
     		},error: function(xhr,status, error){
      		alert("에러발생");
      		}
      });
    }
    function checkSearchedWord(obj){
        if(obj.length >0){
            //특수문자 제거
            
            var expText = /[%=><]/ ;
            
            if(expText.test(obj) == true){
                alert("특수문자를 입력 할수 없습니다.") ;
                obj.value = obj.split(expText).join(""); 
                return false;
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
                    alert("\"" + sqlArray[i]+"\"와(과) 같은 특정문자로 검색할 수 없습니다.");
                    obj =obj.replace(regex, "");
                    return false;
                }
            }
        }
    	return true ;
    }
</script>
</html>
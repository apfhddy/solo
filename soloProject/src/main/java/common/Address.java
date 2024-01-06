package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class Address {
	
	public static String getAddress(String str) throws UnsupportedEncodingException, IOException {
		str = str.replaceAll(" ","");
		int currentPage = 1; //페이지수
		int countPerPage = 30;//몇 줄 받을건지
		String confmKey = "devU01TX0FVVEgyMDI0MDEwNDE1MzI0NTExNDQwNjU=";
		String resultType = "json";
		
		String apiUrl = 
				"https://business.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&confmKey="+confmKey+"&resultType="+resultType+"&keyword="+str;
		URL url = new URL(apiUrl);
		BufferedReader br = new BufferedReader(
				 new InputStreamReader(
				 url.openStream(),"UTF-8"));
		
		String line = null;
		StringBuffer sb = new StringBuffer();
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		return sb.toString();
	}
}

package mainController;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import detail.Terms.Terms_DAO;

public class SessionFilter implements Filter{
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("서버 실행");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		request.setCharacterEncoding("UTF-8");
		
		String[] paths = req.getServletPath().substring(1).split("/");

		
		boolean isAjax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
		//해당 페이지 벗어나면 세션삭제
		if(req.getSession().getAttribute("join") != null && !paths[0].equals("join") && !isAjax) 
			req.getSession().removeAttribute("join");
		
//		if(paths[0].equals("myPage") && req.getSession().getAttribute("login") == null) {
//			err = true;
//		}
//		
//		if(paths[0].equals("join")) {
//			if(paths[1].equals("certified") && req.getSession().getAttribute("join") == null)
//				err = true;
//		}
		
		
		
		boolean err = false;
		
		switch(paths[0]) {
			case "myPage":
				err = req.getSession().getAttribute("login") == null;
				break;
			case "join":
				err = paths[1].equals("certified") && req.getSession().getAttribute("join") == null;
				break;
			case "order":
				err = req.getSession().getAttribute("orderList") == null;
				break;
		}
		
//		if(paths[0].equals("check")) {
//			
//			Set<String> keys = request.getParameterMap().keySet();
//			
//			for(String key : keys) {
//				if(!InjectionProtect.checkChar(request.getParameter(key))) {
//					req.setAttribute("ij", 1);
//					break;
//				}
//			}
//		}
		
		
		if(err) {
			res.sendRedirect("/solo/");
		}else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("서버 종료");
		
	}

}

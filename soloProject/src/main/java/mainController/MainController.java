package mainController;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController implements ControllerPath{
	
	
	@RequestMapping("/")
	public String home(Locale locale, HttpServletRequest req) {
		req.setAttribute("a", 1);
		return HOME;
	}
	
}

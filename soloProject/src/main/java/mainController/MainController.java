package mainController;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import common.ControllerPath;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController implements ControllerPath{
	
	
	@RequestMapping("/")
	public String home(Locale locale, Model model) {
		return WEB+"test.jsp";
	}
	
}

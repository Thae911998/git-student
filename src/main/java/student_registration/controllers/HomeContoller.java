package student_registration.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeContoller {
	@RequestMapping("stureg")
	public String index() {
		return "welcome";
}
}
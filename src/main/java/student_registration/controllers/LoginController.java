package student_registration.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import student_registration.models.Login;
import student_registration.models.User;
import student_registration.persistance.UserRepository;

@Controller
public class LoginController {
	@GetMapping(value="/")
	public ModelAndView showLogin() {
		return new ModelAndView("login","login",new Login());
	}
	
	@PostMapping(value="/createlogin")
	public String checklogin(@ModelAttribute("login")Login login) {
		UserRepository userRepo=new UserRepository();//userrepository obj
		User user=new User();//userobj
		user=userRepo.loginUser(login);
		if(user!=null && user.getEmail()!=null) {
			return "welcome";
		}else {
			return "redirect:/";
		}
	}
	@GetMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}

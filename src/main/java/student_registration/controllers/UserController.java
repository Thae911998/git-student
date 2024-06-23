package student_registration.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import student_registration.models.User;
import student_registration.persistance.UserRepository;



@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/user")
	public ModelAndView userList(ModelMap map) {
		List<User> users = userRepo.getAll();
		map.addAttribute("users", users);
		return new ModelAndView("user_list","user",new User());
//		map.addAttribute("users", users);// model
//		return "user_list";// view
	}
	
	@GetMapping("adduser")
	public ModelAndView addUser(ModelMap map) {
		
		return new ModelAndView("user_register","user",new User());
	}
	//post are wirte to get the data from form
	@PostMapping("adduser")
	public String addUser(@ModelAttribute("user")@Validated User user,BindingResult bResult,ModelMap map) {
		
		
		if(bResult.hasErrors()) {
			map.addAttribute("user",userRepo.getAll());
			return "user_list";
		}
		int rs=userRepo.insertUser(user);
		//repo adding fail due to Sql error or connection timeout 
		if(rs==0) {
			map.addAttribute("error_msg","Database Error");
			map.addAttribute("user",userRepo.getAll());
			return "user_register";
		}
		return "redirect:/user";
	}
	
	@GetMapping("edituser/{user_id}")
	public ModelAndView editStudent(@PathVariable Integer user_id,ModelMap map) {
	User user=userRepo.getById(user_id);
		
		return new ModelAndView("user_update","user",user);
	}
	@PostMapping("edituser")
	public String editAuthor(@ModelAttribute("user")@Validated User user,BindingResult bResult,ModelMap map) {
		if(bResult.hasErrors()) {
			return "user_update";
		}
		int rs=userRepo.updateuser(user);
		
		if(rs==0) {
			map.addAttribute("error_msg","In Updating, Database something wrong.");
			return "user_update";
		}
		else {
			return "redirect:/user";
		}
	}
	
	@GetMapping("deleteuser/{user_id}")
	public String deleteAuthor(@PathVariable int user_id ) {
		userRepo.deleteUserById(user_id);
		return "redirect:/user";
	}

}
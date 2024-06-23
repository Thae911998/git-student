package student_registration.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import student_registration.models.Course;
import student_registration.persistance.CourseRepository;

@Controller

public class CourseController {
	
	@Autowired
	CourseRepository courseRepo;
	
	@RequestMapping("/course")
	public ModelAndView showcourse() {
		return new ModelAndView("course_register","course",new Course());
	}
	@PostMapping(value="/createcourse")
	public String createCourse(@ModelAttribute("course")@Validated Course course,BindingResult bresult,ModelMap map) {
		if(bresult.hasErrors()) {
			return "course_register";
		}
		int rs=courseRepo.InsertCourse(course);
		if(rs==0) {
			map.addAttribute("error_msg","Database Error");
			return "course_register";
		}
			return "welcome";
		}
	}


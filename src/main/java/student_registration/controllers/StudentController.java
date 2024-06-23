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

import student_registration.models.Course;
import student_registration.models.Education;
import student_registration.models.Student;
import student_registration.persistance.CourseRepository;
import student_registration.persistance.EducationRepository;
import student_registration.persistance.StudentRepository;

@Controller

public class StudentController {
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	EducationRepository educationRepo;
	@Autowired
	CourseRepository courseRepo;

	@RequestMapping("students")
	protected String displayAll(ModelMap map) {

		List<Student> students = studentRepo.getAll();
		map.addAttribute("students", students);// model
		return "student_search";// view
	}

	@GetMapping("/addstudent") // can duplicate name get and post
	public ModelAndView addStudent(ModelMap map) { // together with model and view
		List<Education> education = educationRepo.getAll();
		map.addAttribute("selected_education", education);
		List<Course> course = courseRepo.getAllCourse();
		map.addAttribute("selected_course", course);
		return new ModelAndView("add_students", "student", new Student());// new to book
	}

	@PostMapping("/addstudent")
	public String addStudent(@ModelAttribute("student") @Validated Student student, BindingResult bResult,
			ModelMap map) {

		if (bResult.hasErrors()) {
			map.addAttribute("selected_education", educationRepo.getAll());
			map.addAttribute("selected_course", courseRepo.getAllCourse());
			return "add_students";// =====return new ModelAndView("add_book","book",book);
		}
		int rs = studentRepo.add(student);
		if (rs == 0) {
			map.addAttribute("student", student);// shortwrite of ModelAndView
			map.addAttribute("error_msg", "SQL Insert error");

			return "add_students";
		} else {
			return "redirect:/students";// next action to redirect(String return nee)

		}
	}

	@GetMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		// (no need)String code=request.getParameter("code");
		studentRepo.delete(id);
		return "redirect:/students";
	}

	@GetMapping("/editstudent/{id}") // route path ye code(code1,code2---)

	public ModelAndView editStudent(@PathVariable Integer id, ModelMap map) {

		Student student = new Student();

		student = studentRepo.getById(id);// call old information from database

		return new ModelAndView("edit_students", "student", student);// edit_book ko call,modelattribute to
																		// book(modelandview return nee)
	}

	@PostMapping("/editstudent") // empty data ko check with validated and catch with binding result
	public String editStudent(@ModelAttribute("student") @Validated Student student, BindingResult bResult,
			ModelMap map) {

		if (bResult.hasErrors()) {
			// map.addAttribute("error_msg",bResult.getFieldError());
			map.addAttribute("student", student);

			return "edit_student";
		}

		int rs = studentRepo.edit(student);// new edit data to database
		if (rs == 0) {
			map.addAttribute("error_msg", "SQL Edit Error");
			map.addAttribute("student", student);
			return "edit_students";
		} else {
			return "redirect:/students";
		}

	}
}

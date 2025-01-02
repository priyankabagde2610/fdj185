package edu.cjc.studentmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.studentmanagementapp.model.Student;
import edu.cjc.studentmanagementapp.servicei.StudentService;

@Controller
public class AdminController
{
	@Autowired
	private StudentService ssi;
	@RequestMapping("/")
	public String preLogin()
	{
		
	  return "login";	
	}
	@RequestMapping("/login")
	public String onlogin(@RequestParam String username,@RequestParam String password,Model m)
	{
		if(username.equals("admin") && password.equals("admin"))
		{
			List<Student> students=ssi.getAllStudents();
			m.addAttribute("data",students);
			return "adminscreen";
		}
		else
		{
			m.addAttribute("login_fail","Enter valid login details.");
			return "login";
		}
		
	}
	@RequestMapping("enroll_student")
	public String saveStudent(@ModelAttribute Student student,Model m)
	{
		ssi.saveStudentDetails(student);
		List<Student> students=ssi.getAllStudents();
		m.addAttribute("data",students);
		return "adminscreen";
	}
	
	
	
		
	

}

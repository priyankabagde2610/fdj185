package com.cjc.springbootcrudapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.springbootcrudapp.model.Student;
import com.cjc.springbootcrudapp.servicei.StudentServiceI;

@Controller
public class Homecontroller
{
	@Autowired
	StudentServiceI ssi;
	@RequestMapping("/")
	public String preLogin()
	{
		return"login";
	}
	
	@RequestMapping("/openregister")
	public String preRegister()
	{
		return"register";
	}
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute Student s)
	{
		ssi.saveStudent(s);
		return "login";
	}
	
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("username") String u,@RequestParam("password")String p,Model m)
	
	{
		List<Student>list=ssi.loginStudent(u,p);
		if(!list.isEmpty())
		{
		m.addAttribute("data",list);
		return "success";
		}
		return "login";
		
	}
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("rollno") int rollno,Model m)
	{
		List<Student> list=ssi.deleteStudent(rollno);
		m.addAttribute("data",list);
		return "success";
	}
	@RequestMapping("/edit")
	public String editStudent(@RequestParam("rollno")int rollno,Model m)
	{
		Student s=ssi.editStudent(rollno);
		if(s!=null)
		{
			m.addAttribute("stu",s);
			return "edit";
		}
		return "login";
		}
		
	@RequestMapping("/update")
	public String updateStudent(@ModelAttribute Student s,Model m)
	{
		List<Student> list=ssi.updateStudent(s);
		m.addAttribute("data",list);
		return "success";
	}
		
		
	}




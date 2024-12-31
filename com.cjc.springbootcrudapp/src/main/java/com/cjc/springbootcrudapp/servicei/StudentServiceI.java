package com.cjc.springbootcrudapp.servicei;

import java.util.List;


import com.cjc.springbootcrudapp.model.Student;

public interface StudentServiceI
{
	public void saveStudent(Student s);
	
	public List<Student> loginStudent(String u,String p);

	public List<Student> deleteStudent(int rollno);

	public Student editStudent(int rollno);

	public List<Student> updateStudent(Student s);

}

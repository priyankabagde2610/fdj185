package edu.cjc.studentmanagementapp.servicei;


import java.util.List;

import edu.cjc.studentmanagementapp.model.Student;

public interface StudentService
{
	public void saveStudentDetails(Student s);

	public List<Student> getAllStudents();

}

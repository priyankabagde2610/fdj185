package edu.cjc.studentmanagementapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.studentmanagementapp.model.Student;
import edu.cjc.studentmanagementapp.repositary.StudentRepository;
import edu.cjc.studentmanagementapp.servicei.StudentService;
@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository sr;

	@Override
	public void saveStudentDetails(Student s) 
	{
		
		sr.save(s);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}

	

	

	
}

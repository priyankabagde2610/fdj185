package com.cjc.springbootcrudapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.springbootcrudapp.model.Student;
import com.cjc.springbootcrudapp.repositary.StudentRepositary;
import com.cjc.springbootcrudapp.servicei.StudentServiceI;
@Service
public class StudentServiceImpl implements StudentServiceI
{
 @Autowired
 StudentRepositary sr;
	@Override
	public void saveStudent(Student s) 
	{
		
		sr.save(s);
		
	}

	@Override
	public List<Student> loginStudent(String u, String p) {
		if(u.equals("admin")&& p.equals("admin"))
		{
			return (List<Student>)sr.findAll();
		}
		else
		{
			return sr.findByUsernameAndPassword(u, p);
		}
	}

	@Override
	public List<Student> deleteStudent(int rollno) 
	{
		
		sr.deleteById(rollno);
		//sr.deleteByRollno(rollno);
		//sr.deleteData(rollno);
		//return sr.getAlldata();
		return (List<Student>) sr.findAll();
	   
	}

	@Override
	public Student editStudent(int rollno)
	{
		
		Optional<Student> op=sr.findById(rollno);
		if(op.isPresent())
		{
			Student s=op.get();
			return s;
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Student> updateStudent(Student s) {
		sr.save(s);
		return (List<Student>) (sr.findAll());
	}

	
	

}

package com.cjc.springbootcrudapp.repositary;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cjc.springbootcrudapp.model.Student;

import jakarta.transaction.Transactional;

import java.util.List;


@Repository
public interface StudentRepositary extends CrudRepository<Student, Integer>
{
	
 public List<Student> findByUsernameAndPassword(String username,String password);
 @Transactional
 public void deleteByRollno(int rollno);
 
 @Transactional
 @Modifying
 @Query(value="delete from student where rollno=?1rollno ",nativeQuery=true)
 public void deleteData(int rollno);
 @Query(value="select * from student",nativeQuery=true)
 public List<Student> getAlldata();
 
 
 
 
}

package edu.cjc.studentmanagementapp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cjc.studentmanagementapp.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}

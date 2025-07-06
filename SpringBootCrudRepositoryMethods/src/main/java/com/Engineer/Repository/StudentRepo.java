package com.Engineer.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Engineer.Model.Student;

public interface StudentRepo  extends CrudRepository<Student, Integer>{

}

package com.Engineer.Service;

import java.util.List;
import java.util.Optional;

import com.Engineer.Model.Student;

public interface StudentManipulation {

    // 1. Insert a single student
    Student insert(Student std);

    // 2. Insert multiple students
    Iterable<Student> insertAll(List<Student> list);

    // 3. Get student by ID
    Optional<Student> getById(Integer id);

    // 4. Check if student exists by ID
    boolean isExist(Integer id);

    // 5. Get all students
    Iterable<Student> getAll();

    // 6. Get students by a list of IDs
    Iterable<Student> getAllByIds(List<Integer> ids);

    // 7. Count total number of students
    long totalStudent();

    // 8. Delete student by ID
    void deleteById(Integer id);

    // 9. Delete student by object
    void deleteStudent(Student s);

    // 10. Delete all students by a list of IDs
    void deleteAllByIds(List<Integer> ids);

    // 11. Delete all given student objects
    void deleteAllGiven(List<Student> list);

    // 12. Delete all students from the table
    void deleteAllStudents();
}

package com.Engineer.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.Engineer.Model.Student;
import com.Engineer.Service.StudentService;

@Controller
public class StudentController {

    @Autowired
    private StudentService serv;

    // 1. Insert one student
    public Student insertOneStudent(Student s) {
        return serv.insert(s);
    }

    // 2. Insert multiple students
    public Iterable<Student> insertMultipleStudents(List<Student> students) {
        return serv.insertAll(students);
    }

    // 3. Get student by ID
    public Optional<Student> fetchStudentById(Integer id) {
        return serv.getById(id);
    }

    // 4. Check if student exists
    public boolean isStudentExist(Integer id) {
        return serv.isExist(id);
    }

    // 5. Fetch all students
    public Iterable<Student> fetchAllStudents() {
        return serv.getAll();
    }

    // 6. Fetch multiple students by IDs
    public Iterable<Student> fetchStudentsByIds(List<Integer> ids) {
        return serv.getAllByIds(ids);
    }

    // 7. Count total students
    public long totalStudentCount() {
        return serv.totalStudent();
    }

    // 8. Delete student by ID
    public void deleteStudentById(Integer id) {
        serv.deleteById(id);
    }

    // 9. Delete student by object
    public void deleteStudentObject(Student student) {
        serv.deleteStudent(student);
    }

    // 10. Delete by IDs list
    public void deleteStudentsByIds(List<Integer> ids) {
        serv.deleteAllByIds(ids);
    }

    // 11. Delete by student list
    public void deleteStudentsList(List<Student> students) {
        serv.deleteAllGiven(students);
    }

    // 12. Delete all students
    public void deleteAllStudents() {
        serv.deleteAllStudents();
    }
}

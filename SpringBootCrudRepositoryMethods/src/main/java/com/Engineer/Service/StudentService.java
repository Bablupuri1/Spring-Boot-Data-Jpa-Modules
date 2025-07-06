package com.Engineer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Engineer.Model.Student;
import com.Engineer.Repository.StudentRepo;

@Service
public class StudentService implements StudentManipulation {

    @Autowired
    private StudentRepo Srepo;

    @Override
    public Student insert(Student std) {
        return Srepo.save(std); // 1
    }

    @Override
    public Iterable<Student> insertAll(List<Student> list) {
        return Srepo.saveAll(list); // 2
    }

    @Override
    public Optional<Student> getById(Integer id) {
        return Srepo.findById(id); // 3
    }

    @Override
    public boolean isExist(Integer id) {
        return Srepo.existsById(id); // 4
    }

    @Override
    public Iterable<Student> getAll() {
        return Srepo.findAll(); // 5
    }

    @Override
    public Iterable<Student> getAllByIds(List<Integer> ids) {
        return Srepo.findAllById(ids); // 6
    }

    @Override
    public long totalStudent() {
        return Srepo.count(); // 7
    }

    @Override
    public void deleteById(Integer id) {
        Srepo.deleteById(id); // 8
    }

    @Override
    public void deleteStudent(Student s) {
        Srepo.delete(s); // 9
    }

    @Override
    public void deleteAllByIds(List<Integer> ids) {
        Srepo.deleteAllById(ids); // 10
    }

    @Override
    public void deleteAllGiven(List<Student> list) {
        Srepo.deleteAll(list); // 11
    }

    @Override
    public void deleteAllStudents() {
        Srepo.deleteAll(); // 12
    }
}

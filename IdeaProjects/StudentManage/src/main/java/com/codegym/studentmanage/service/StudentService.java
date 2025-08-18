package com.codegym.studentmanage.service;

import com.codegym.studentmanage.model.Student;
import com.codegym.studentmanage.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
@Autowired
private IStudentRepository istudentRepository;
    @Override
    public List<Student> findAll() {
        return istudentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return istudentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        istudentRepository.save(student);

    }

    @Override
    public void remove(Long id) {
        istudentRepository.remove(id);

    }
}

package com.example.springbootbt.springboottest.service.student;

import com.example.springbootbt.springboottest.model.Student;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    List<Student> searchByName(String keyword);
    List<Student> searchByClass(String className);
}

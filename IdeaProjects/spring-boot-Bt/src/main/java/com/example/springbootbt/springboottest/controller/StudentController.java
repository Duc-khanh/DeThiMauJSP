package com.example.springbootbt.springboottest.controller;

import com.example.springbootbt.springboottest.model.Student;
import com.example.springbootbt.springboottest.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentService.findById(id)
                .map(student -> {
                    student.setFirstName(updatedStudent.getFirstName());
                    student.setLastName(updatedStudent.getLastName());
                    student.setDob(updatedStudent.getDob());
                    student.setEmail(updatedStudent.getEmail());
                    student.setPhone(updatedStudent.getPhone());
                    student.setClassName(updatedStudent.getClassName());
                    student.setAddress(updatedStudent.getAddress());
                    return ResponseEntity.ok(studentService.save(student));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        if (studentService.findById(id).isPresent()) {
            studentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/name")
    public List<Student> searchByName(@RequestParam String keyword) {
        return studentService.searchByName(keyword);
    }

    @GetMapping("/search/class")
    public List<Student> searchByClass(@RequestParam String className) {
        return studentService.searchByClass(className);
    }
}


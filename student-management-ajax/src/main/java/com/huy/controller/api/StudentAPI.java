package com.huy.controller.api;

import com.huy.model.ProvinceBirth;
import com.huy.model.Student;
import com.huy.service.provinceBirth.IProvinceBirthService;
import com.huy.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentAPI {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IProvinceBirthService provinceBirthService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> allStudents() {
        Iterable<Student> students = studentService.findAll();
        if (((List) students).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Student> getId(@PathVariable Long id) {
        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        if (student.getId() != null) {
            return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
        }
        Optional<ProvinceBirth> provinceBirth = provinceBirthService.findById(student.getProvinceBirth().getId());
        if (provinceBirth.isPresent()) {
            student.setProvinceBirth(provinceBirth.get());
            return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Student> deleteStudent(@RequestBody Map<String, String> json) {
        Long id = Long.valueOf(json.get("id"));
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(studentOptional.get(), HttpStatus.NO_CONTENT);
    }
}

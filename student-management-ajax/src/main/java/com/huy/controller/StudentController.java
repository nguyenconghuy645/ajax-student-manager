package com.huy.controller;

import com.huy.service.student.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView("/student/list");
        return modelAndView;
    }
}

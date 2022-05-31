package ru.yajaneya.dz7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import ru.yajaneya.dz7.entities.Student;
import ru.yajaneya.dz7.services.StudentsService;

import java.util.List;

@RestController
//@RequestMapping("students")
@RequiredArgsConstructor
public class    StudentsController {

    private final StudentsService service;

    @PostMapping ("/add")
    public RedirectView putNewStudent (@ModelAttribute("student") Student student) {
        final RedirectView redirectView = new RedirectView("index", true);
        Student saveStudent = service.saveNewStudent(student);
        return redirectView;
    }
    @PostMapping ("/del/{id}")
    public RedirectView deleteStudent (@PathVariable Long id) {
        final RedirectView redirectView = new RedirectView("../index", true);
        service.deleteStudent(id);
        return redirectView;
    }
    @PostMapping
    public Student updateStudent (@RequestBody Student student) {
        return service.updateStudent(student);
    }
    @GetMapping
    public List<Student> getAll () {
        return service.getAll();
    }
    @GetMapping ("/{id}")
    public Student getStudent (@PathVariable Long id) {
        return service.getStudent(id);
    }

}

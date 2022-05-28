package ru.yajaneya.dz7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yajaneya.dz7.entities.Student;
import ru.yajaneya.dz7.services.StudentsService;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentsController {

    private final StudentsService service;

    @GetMapping
    public List<Student> getAll () {
        return service.getAll();
    }

    @GetMapping ("/{id}")
    public Student getStudent (@PathVariable Long id) {
        return service.getStudent(id);
    }

    @PutMapping
    public Student putNewStudent (@RequestBody Student student) {
        return service.saveNewStudent(student);
    }

    @PostMapping
    public Student updateStudent (@RequestBody Student student) {
        return service.updateStudent(student);
    }

    @DeleteMapping ("/{id}")
    public void deleteStudent (@PathVariable Long id) {
        service.deleteStudent(id);
    }

}

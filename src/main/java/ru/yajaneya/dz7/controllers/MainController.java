package ru.yajaneya.dz7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import ru.yajaneya.dz7.entities.Student;
import ru.yajaneya.dz7.services.StudentsService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final StudentsService service;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String viewStudents (Model model) {
        List<Student> students = service.getAll();
        Student student = new Student();
        students.forEach(s -> System.out.println(s));
        model.addAttribute("students", students);
        model.addAttribute("student", student);
        return "index";
    }

    @PostMapping("/refresh")
    public RedirectView refreshPage () {
        final RedirectView redirectView = new RedirectView("index", true);
        return redirectView;
    }

}

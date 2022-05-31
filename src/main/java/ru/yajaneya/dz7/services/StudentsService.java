package ru.yajaneya.dz7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yajaneya.dz7.entities.Student;
import ru.yajaneya.dz7.repositories.StudentsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentsRepository repository;

    public List<Student> getAll () {
        return repository.findAll();
    }

    public Student getStudent (Long id) {
        return repository.findById(id).get();
    }

    public Student saveNewStudent (Student student) {
        student.setId(null);
        return repository.save(student);
    }

    public Student updateStudent (Student student) {
        return repository.save(student);
    }

    public void deleteStudent (Long id) {
        repository.deleteById(id);
    }

}

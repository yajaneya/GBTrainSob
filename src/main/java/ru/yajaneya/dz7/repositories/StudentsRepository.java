package ru.yajaneya.dz7.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yajaneya.dz7.entities.Student;

import java.util.Optional;

@Repository
public interface StudentsRepository extends JpaRepository<Student,Long> {
}

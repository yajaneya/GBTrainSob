package dz5.dao;

import dz5.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {

    Student add (Student student);
    void delete (Long id);
    Student update (Student student);
    Optional<Student> get (Long id);
    List<Student> getInterval (Long start_id, Long end_id);
    List<Student> getAll ();

}

package dz5.dao;

import dz5.entities.Student;
import dz5.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao{
    SessionFactory factory = SessionFactoryUtils.get();

    public StudentDaoImpl() {
    }

    @Override
    public Student add(Student student) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Student where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public Student update(Student student) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Optional<Student> get(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.createQuery("select s from Student s where id = :id", Student.class)
                    .setParameter("id", id)
                    .getSingleResult();
            session.getTransaction().commit();
            return Optional.of(student);
        }
    }

    @Override
    public List<Student> getInterval (Long start_id, Long end_id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("select s from Student s where id >= :start_id and id <= :end_id", Student.class)
                    .setParameter("start_id", start_id)
                    .setParameter("end_id", end_id)
                    .getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public List<Student> getAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> students = session.createQuery("select s from Student s", Student.class)
                    .getResultList();
            session.getTransaction().commit();
            return students;
        }
    }

}

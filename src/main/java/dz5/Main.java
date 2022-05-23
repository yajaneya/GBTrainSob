package dz5;

import dz5.dao.StudentDao;
import dz5.dao.StudentDaoImpl;
import dz5.entities.Student;

public class Main {
    public static void main(String[] args) {
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();

        // Добавление 1000 студентов
        for (int i = 0; i < 1000; i++) {
            student.setName("Vasya" + i);
            student.setMark((int) (Math.random()*5+1));
            dao.add(student);
        }

        System.out.println("*** Удаление студента ***");
        System.out.println("До: ");
        dao.getInterval(2l, 4l).forEach(s -> System.out.println(s));
        dao.delete(3l);
        System.out.println("После: ");
        dao.getInterval(2l, 4l).forEach(s -> System.out.println(s));
        System.out.println("***************");
        System.out.println();

        System.out.println("*** Изменение студента ***");
        student.setId(4l);
        student.setName("Nastya");
        student.setMark(5);
        System.out.println("До: " + dao.get(4l));
        dao.update(student);
        System.out.println("После: " + dao.get(4l));
        System.out.println("***************");
        System.out.println();

        System.out.println("Один студент: ");
        System.out.println(dao.get(11l).get());
        System.out.println("***************");
        System.out.println();

        System.out.println("Все студенты:");
        dao.getAll().forEach(s -> System.out.println(s));

    }
}

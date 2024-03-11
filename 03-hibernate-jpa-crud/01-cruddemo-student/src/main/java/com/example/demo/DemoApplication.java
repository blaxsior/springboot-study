package com.example.demo;

import com.example.demo.student.Student;
import com.example.demo.student.StudentDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner cmr(StudentDAO studentDao, EntityManager em, TempComponent tc) {
        return args -> {
            System.out.println("hello world!");
            for (var arg : args) {
                System.out.println(arg);
            }
//			createStudent(studentDao);
//            readStudent(studentDao);
//            readStudents(em);
//            updateStudent1(studentDao);
//            tc.updateStudent(em);
//            deleteStudent1(studentDao);
            tc.doSomething(studentDao);
        };
    }

    private void createStudent(StudentDAO studentDao) {
        System.out.println("새로운 student 객체 생성");
        var student = new Student.Builder()
                .firstName("길동")
                .lastName("홍")
                .email("hello@world.com")
                .build();
        studentDao.save(student);

        System.out.println(student);
    }

    private void readStudent(StudentDAO studentDao) {
        var student = studentDao.findById(1);
        System.out.println(student);
    }

    private void readStudents(EntityManager em) {
        TypedQuery<Student> query = em.createQuery("from Student where id between :start and :stop", Student.class)
                .setParameter("start", 1)
                .setParameter("stop", 5);


        List<Student> students = query.getResultList();
        for (var student : students) {
            System.out.println(student);
        }
    }

    private void updateStudent1(StudentDAO studentDAO) {
        var student = studentDAO.findById(1);
        if(student == null) return;

        System.out.println(student);

        student.setFirstName("철수");
        student.setLastName("김");
        studentDAO.update(student);

        System.out.println(student);
    }

    private void updateStudent2(EntityManager em, StudentDAO dao) {
        var transaction = em.getTransaction();
        var id = 1;

        transaction.begin(); // 트랜잭션 시작
        var changed_line_count = em.createQuery("UPDATE Student SET email='world@com' WHERE id=:id")
                .setParameter("id", id)
                .executeUpdate();
        transaction.commit(); // 트랜잭션 끝

        System.out.println(changed_line_count);

        var student = em.find(Student.class, id);
        System.out.println(student);
    }

    private void deleteStudent1(StudentDAO dao) {
        dao.deleteById1(1);
        dao.deleteById2(2);
    }

    // transactional이 컴포넌트
    @Component
    class TempComponent {
        @Transactional
        public void updateStudent(EntityManager em) {
            var id = 1;
            var changed_line_count = em.createQuery("UPDATE Student SET email='world@com' WHERE id=:id")
                    .setParameter("id", id)
                    .executeUpdate();

            System.out.println(changed_line_count);

            var student = em.find(Student.class, id);
            System.out.println(student);
        }

        @Transactional
        public void doSomething(StudentDAO dao) {
            var student = new Student.Builder()
                    .firstName("길동")
                    .lastName("홍")
                    .email("hello@world.com")
                    .build();
            dao.save(student); // 저장 발생

            System.out.println(student);

            student.setEmail("test@123.com");
            dao.update(student);

            dao.deleteById1(student.getId());
        }
    }
}

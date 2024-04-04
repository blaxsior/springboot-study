package com.example.demo;

import com.example.demo.course.dao.CourseDao;
import com.example.demo.course.entity.Course;
import com.example.demo.instructor.dao.InstructorDao;
import com.example.demo.instructor.entity.Instructor;
import com.example.demo.review.entity.Review;
import com.example.demo.student.dao.StudentDao;
import com.example.demo.student.entity.Student;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao, CourseDao courseDao, StudentDao studentDao) {

		return args -> {
//			findCourseAndStudents(courseDao);
//			findStudentAndCoursesById(studentDao);
//			addStudentsCourses(studentDao);
//			courseDao.deleteById(10);
//			createCourseAndStudents(courseDao);
			studentDao.deleteById(4);
		};
	}
	private void createCourseAndStudents(CourseDao dao){
		var course = new Course("course name A");

		course.addStudent(new Student("gildong1", "hong", "test1@test.com"));
		course.addStudent(new Student("gildong2", "hong", "test2@test.com"));
		course.addStudent(new Student("gildong3", "hong", "test3@test.com"));
		// cascade = {CascadeType.PERSIST} 에 의해 함께 삽입된다.
		dao.save(course);
	}
	private void deleteCourse(CourseDao dao) {
		var id = 10;

		dao.deleteById(id);
	}

	private void findCourseAndStudents(CourseDao dao) {
		var id = 10;

		var course = dao.findWithStudentsById(id);
		System.out.println(course.getStudents());
	}

	private void findStudentAndCoursesById(StudentDao dao) {
		var id = 1;

		var optStudent = dao.findWithCoursesById(id);
		if(optStudent.isPresent()) {
			System.out.println(optStudent.get().getCourses());
		}
	}

	private void addStudentsCourses(StudentDao dao) {
		var id = 1;
		var opt = dao.findWithCoursesById(id);
		// 연관 엔티티를 함께 가져옴

		if(opt.isEmpty()) {
			System.out.println("no student");
			return;
		}

		var student = opt.get();
		student.addCourse(new Course("tt1"));
		student.addCourse(new Course("tt2"));

		dao.update(student);

		System.out.println(student.getCourses());
	}
}

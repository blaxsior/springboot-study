package com.example.demo;

import com.example.demo.course.dao.CourseDao;
import com.example.demo.course.entity.Course;
import com.example.demo.instructor.dao.InstructorDao;
import com.example.demo.instructor.entity.Instructor;
import com.example.demo.review.entity.Review;
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
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao, CourseDao courseDao) {

		return args -> {
//			createInstructorCourses(instructorDao);
//			findInstructor(instructorDao);
//			findCoursesForInstructor(instructorDao, courseDao);
//			findInstructorWithCourses(instructorDao);
//			deleteInstructor(instructorDao);
			deleteCourse(courseDao);
//			createCourseAndReviews(courseDao);
//			findCourseWithReviews(courseDao);
		};
	}

	private void createInstructorCourses(InstructorDao dao) {
		// eager인 경우 left join으로 쿼리 한번만 날림
		var instructor = new Instructor("susan", "cat", "test3@test.com");
		var course1 = new Course("special math dreamer");
		var course2 = new Course("run devil run");

		// CascadeType.PERSIST에 의해 함께 저장된다.
		instructor.addCourse(course1);
		instructor.addCourse(course2);

		dao.save(instructor);
	}

	private void findInstructor(InstructorDao dao) {
		final var id = 1;
		var instructor = dao.findById(id);

		// OneToMany는 기본적으로 Lazy.
		// findById에 의해 하이버네이트 세션과 분리된 instructor이 가진 courses을 출력하려고 시도,
		// no session 에러가 발생하게 됨!

		if(instructor == null) {
			System.out.println("no instructor id = " + id);
			return;
		}
		// lazy loading
		System.out.println("instructor: " + instructor);
	}

	private void findCoursesForInstructor(InstructorDao instructorDao, CourseDao courseDao) {
		var id = 1;

		var instructor = instructorDao.findById(id);

		var courses = courseDao.findAllByInstructorId(instructor.getId());
		instructor.setCourses(courses);

		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(InstructorDao dao) {
		var id = 1;

		var instructor = dao.findWithCoursesById(id);

		System.out.println(instructor);
	}

	private void updateInstructor(InstructorDao dao) {
		var id = 1;
		var instructor = dao.findWithCoursesById(id);

		if(instructor != null) {
			instructor.setLastName("TESTER");
			dao.update(instructor);
		}
	}

	private void deleteInstructor(InstructorDao dao) {
		var id = 1;
		dao.removeById(id);
	}

	private void deleteCourse(CourseDao dao) {
		var id = 10;

		dao.deleteById(id);
	}

	private void createCourseAndReviews(CourseDao dao) {
		Course course = new Course("this is course");
		course.addReview((new Review("review1")));
		course.addReview((new Review("review2")));
		course.addReview((new Review("review3")));
		course.addReview((new Review("review4")));

		dao.save(course);
	}

	private void findCourseWithReviews(CourseDao dao) {
		var id = 10;
		var course = dao.findWithReviewsById(id);
		System.out.println(course);
	}
}

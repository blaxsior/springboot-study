package com.example.demo;

import com.example.demo.instructor.dao.InstructorDao;
import com.example.demo.instructor.dao.InstructorDetailDao;
import com.example.demo.instructor.entity.Instructor;
import com.example.demo.instructor.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(InstructorDao instructorDao, InstructorDetailDao instructorDetailDao) {

		return args -> {
//			createInstructor(instructorDao);
//			findInstructorById(instructorDao);
//			deleteInstructorById(instructorDao);
//			findInstructorDetailById(instructorDetailDao);
			deleteInstructorDetailById(instructorDetailDao);
		};
	}


	private void createInstructor(InstructorDao dao) {
		var instructor = new Instructor("marry", "jin", "marry-jin@test.com");

		var instructordetail = new InstructorDetail("http://test2.com", "running");
		instructor.setInstructorDetail(instructordetail);

		dao.save(instructor);

		System.out.println("saved instructor: " + instructor);
	}

	private void findInstructorById(InstructorDao dao) {
		var id = 1;

		var instructor = dao.findById(id);

		System.out.println("find instructor: " + instructor);
	}

	private void deleteInstructorById(InstructorDao dao) {
		var id = 1; // CascadeType.ALL에 의해 instructor와 instructor_detail이 함께 제거된다.

		dao.deleteById(id);
	}

	private void findInstructorDetailById(InstructorDetailDao dao) {
		var id = 2;
		var instructorDetail = dao.findById(id);

		if(instructorDetail == null) {
			System.out.println("instructor detail not found");
			return;
		}

		System.out.println("instructor detail: " + instructorDetail);
		System.out.println("instructor :" + instructorDetail.getInstructor());
	}

	private void deleteInstructorDetailById(InstructorDetailDao dao) {
		var id = 3; // CascadeType.ALL에 의해 instructor와 instructor_detail이 함께 제거된다.

		dao.deleteById(id);
	}
}

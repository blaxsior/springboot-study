package com.example.demo.instructor.entity;

import com.example.demo.course.entity.Course;
import com.example.demo.review.entity.Review;
import jakarta.persistence.*;
import org.hibernate.Hibernate;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(
            name = "instructor_detail_id", // 현재 테이블의 참조키
            referencedColumnName = "id" // 상대 테이블의 참조되는 키
    )
    private InstructorDetail instructorDetail;

    @OneToMany(fetch = FetchType.LAZY, // 명시 안해도 기본 옵션임
            mappedBy = "instructor", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Course> courses;



    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public List<Course> getCourses() {
        // 코스 객체를 로딩하지 않았다면 null을 반환하도록 설정
        if (!Hibernate.isInitialized(courses)) {
            return null;
        }
        return courses;
    }

    public void addCourse(@NonNull Course course) {
        if (this.courses == null) {
            this.courses = new ArrayList<>();
        }

        this.courses.add(course);
        course.setInstructor(this); // 양방향 매핑
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                ", courses=" + this.getCourses() +
                '}';
    }
}

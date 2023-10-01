package com.learn.springboot.cruddemo;

import com.learn.springboot.cruddemo.dao.AppDAO;
import com.learn.springboot.cruddemo.entity.Course;
import com.learn.springboot.cruddemo.entity.Instructor;
import com.learn.springboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);

			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("deleting course with id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		System.out.println("finding course with id: " + theId);
		Course course = appDAO.findCourseById(theId);
		course.setTitle("Make things simple!");
		appDAO.update(course);
		System.out.println("done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		tempInstructor.setLastName("Chris");
		appDAO.update(tempInstructor);
		System.out.println("done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("temp Instructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("temp Instructor: " + tempInstructor);

		System.out.println("finding courses for instructor id");
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("temp Instructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
		System.out.println("done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Tom", "Harry", "tharry@learn.spring");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"www.test.youtube.com",
						"guitar"
				);

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Airing - the ultimate");
		Course tempCourse2 = new Course("Pinball - the masterclass");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("saving instructor " + tempInstructor);
		System.out.println("saved courses: " + tempInstructor.getCourses());

		appDAO.save(tempInstructor);
		System.out.println("done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int tempId = 4;
		System.out.println("deleting instructor detail with id: " + tempId);
		appDAO.deleteInstructorDetailById(tempId);
		System.out.println("done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int tempInstructorDetailId = 1;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(tempInstructorDetailId);
		System.out.println("Found instructor detail: " + tempInstructorDetail);
		System.out.println("Found instructor: " + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int tempId = 1;
		System.out.println("deleting instructor with id: " + tempId);
		appDAO.deleteInstructorById(tempId);
		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int tempId = 1;
		Instructor dbInstructor = appDAO.findInstructorById(1);
		System.out.println("Found instructor: " +  dbInstructor);
		System.out.println("Found details of instructor: " + dbInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		Instructor tempInstructor =
				new Instructor("Bob", "Dabby", "bdabby@learn.spring");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"www.test.youtube.com",
						"love to code"
				);

		 */


		Instructor tempInstructor =
				new Instructor("Tom", "Harry", "tharry@learn.spring");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"www.test.youtube.com",
						"guitar"
				);


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving the instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("done!");
	}

}

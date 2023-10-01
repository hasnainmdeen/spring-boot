package com.learn.springboot.cruddemo;

import com.learn.springboot.cruddemo.dao.AppDAO;
import com.learn.springboot.cruddemo.entity.Instructor;
import com.learn.springboot.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;

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
			deleteInstructorDetail(appDAO);
		};
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
		int tempId = 2;
		System.out.println("deleting instructor with id: " + 2);
		appDAO.deleteInstructorById(tempId);
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

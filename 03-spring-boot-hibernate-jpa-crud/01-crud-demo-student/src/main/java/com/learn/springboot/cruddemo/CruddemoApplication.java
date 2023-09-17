package com.learn.springboot.cruddemo;

import com.learn.springboot.cruddemo.dao.StudentDAO;
import com.learn.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);
			
			//findAllStudents(studentDAO);

			//findStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int affectedRows = studentDAO.deleteAll();
		System.out.println("Deleted " + affectedRows + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("Deleting student with id: " + id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int theId = 1;
		System.out.println("Getting student with id: " + theId);
		Student s1 = studentDAO.findById(theId);
		System.out.println("Updating student: " + s1);
		s1.setFirstName("John");
		studentDAO.update(s1);
		System.out.println("updated student: " + s1);
	}

	private void findStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("John");

		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void findAllStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student
		System.out.println("creating new student");
		Student tempStudent = new Student("rocky", "della", "della@learn.spring");

		// save the student
		System.out.println("saving the student");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student with id: " + theId);

		// retrieve the student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display retrieved student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 students");
		Student tempStudent1 = new Student("Paul", "John", "paul.john@learn.spring");
		Student tempStudent2 = new Student("Mary", "Doe", "mary.doe@learn.spring");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@learn.spring");

		System.out.println("Saving students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul.doe@learn.spring");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display the id of the saved student
		System.out.println("Saved student with id: " + tempStudent.getId());
	}

}

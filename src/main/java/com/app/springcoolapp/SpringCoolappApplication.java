package com.app.springcoolapp;

import com.app.springcoolapp.dao.InstructorDao;
import com.app.springcoolapp.dao.StudentDao;
import com.app.springcoolapp.entity.Instructor;
import com.app.springcoolapp.entity.InstructorDetail;
import com.app.springcoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class SpringCoolappApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringCoolappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner ->{
			System.out.println("Command Line runner implemented.");
		};
	}

	/*@Bean public CommandLineRunner createInstructor(InstructorDao instructorDao){
		return runner->{
			Instructor instructor = new Instructor("Md. Ashik", "Ali", "khan.ashik@gmail.com");
			instructor.setInstructorDetail(new InstructorDetail("www.youtube.com", "Reading"));
			instructorDao.save(instructor);
			System.out.println("Success...");
		};
	}*/

	@Bean
	public CommandLineRunner commandLineStudentRunner(StudentDao dao){
		return runner ->{
			/*createStudent(dao);*/
			readStudent(dao, 3);
			readAllStudent(dao);
			queryStudentByLastName(dao);
			/*updateStudent(dao);*/
			/*deleteStudent(dao);*/
			/*deleteAllStudent(dao);*/
		};
	}

	private void deleteAllStudent(StudentDao dao) {
		System.out.println("Rows are deleted. Count: " + dao.deleteAll());
	}

	private void deleteStudent(StudentDao dao) {
		int studentId = 5;
		dao.delete(studentId);
	}

	private void updateStudent(StudentDao dao) {

		Student student = dao.findById(10);
		System.out.println("Updating student: " + student);
		if(student!=null){
			student.setFirstName("Md. Rahim");
			student.setLastName("Ahmed");
			student.setEmail("rahim.ahmed@gmail.com");
			dao.update(student);
			System.out.println("After Update: " + student);
		}

	}

	private void queryStudentByLastName(StudentDao dao) {
		List<Student> studentList = dao.findByLastName("Khan");
		studentList.stream().forEach(System.out::println);
	}

	private void readAllStudent(StudentDao studentDao) {
		List<Student> studentList = studentDao.findAll();
		studentList.stream().forEach(student-> System.out.println(student));
	}

	private void createStudent(StudentDao dao) {

		System.out.println("Creating Student Object...");

		Student std = new Student("Md. Ashik Ali", "Khan", "khan.ashik@gmail.com");

		System.out.println("Saving Student object...");

		Student savedStd = dao.save(std);

		System.out.println("Student Object saved. Generated ID: " + savedStd.getId());
	}
	private void readStudent(StudentDao dao, Integer id) {
		Student student = dao.findById(id);
		System.out.println("My student: " + student);
		String s = null;

	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

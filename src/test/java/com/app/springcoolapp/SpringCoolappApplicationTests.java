package com.app.springcoolapp;

import com.app.springcoolapp.dao.CourseDao;
import com.app.springcoolapp.dao.InstructorDao;
import com.app.springcoolapp.dao.InstructorDetailDao;
import com.app.springcoolapp.entity.Course;
import com.app.springcoolapp.entity.Instructor;
import com.app.springcoolapp.entity.InstructorDetail;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;

@SpringBootTest
class SpringCoolappApplicationTests {

	@Autowired
	InstructorDao instructorDao;

	@Autowired
	InstructorDetailDao instructorDetailDao;

	@Autowired
	CourseDao courseDao;

	@Test
	void contextLoads() {
		Instructor instructor = new Instructor("Md. Ashik", "Ali", "khan.ashik@gmail.com");
		instructor.setInstructorDetail(new InstructorDetail("www.youtube.com", "Reading"));

		System.out.println("Success...");
		Optional<Course> byId = courseDao.findById(12l);
		if(byId.isPresent()){
			Course course = byId.get();
			course.setInstructor(instructor);
			List<Course> courses = new ArrayList<>();
			courses.add(course);
		}

		instructorDao.save(instructor);
	}



	@Test
	void printInstructor(){
		long instructorId = 100;
		/*Optional<Instructor> byId = instructorDao.findById(instructorId);

		printInstructor(byId);*/

		instructorId = 2;

		Instructor instructorById = instructorDao.findInstructorById(instructorId);

		System.out.println(instructorById);



		/*if(byId.isPresent()){
			Optional<Course> courseDaoById = courseDao.findById(15l);
			if(courseDaoById.isEmpty()){
				byId.get().setCourses(new ArrayList<>());
			} else{
				byId.get().addCourse(courseDaoById.get());
			}
		}*/
		/*printInstructor(byId);*/
	}

	@Test
	void printInstructorDetail(){
		long id = 2;

		Optional<InstructorDetail> byId = instructorDetailDao.findById(id);

		printInstructorDetail(byId);
	}

	@Test void deleteInstructor(){
		long id=1;
		instructorDao.deleteById(id);
		System.out.println("Deleted successfully");
	}

	@Test void deleteInstructorDetail(){
		long id=3;

		Optional<InstructorDetail> byId = instructorDetailDao.findById(id);

		if(byId.isEmpty()){
			System.out.println("Entity not found for id: " + id);
			return;
		}
		InstructorDetail instructorDetail = byId.get();
		instructorDetail.getInstructor().setInstructorDetail(null);

		instructorDetailDao.delete(instructorDetail);

		//instructorDetailDao.
		System.out.println("Deleted successfully");
	}

	public InstructorDao getInstructorDao() {
		return instructorDao;
	}

	private void printInstructor(Optional<Instructor> byId){
		if(byId.isPresent()){
			System.out.println(byId.get());
		}else{
			System.out.println("Instructor: not found.");
		}
	}

	private void printInstructorDetail(Optional<InstructorDetail> byId){
		if(byId.isPresent()){
			System.out.println(byId.get());
			System.out.println(byId.get().getInstructor());
		}else{
			System.out.println("InstructorDetail: not found.");
		}
	}

	@Test
	public void addCourse() {
		Course course1 = new Course("Course1_" + Math.random()*5);
		courseDao.save(course1);

		Course course2 = new Course("Course2_" + Math.random()*5);
		Optional<Instructor> byId = instructorDao.findById(2l);

		if(byId.isPresent()){
			course2.setInstructor(byId.get());
		}

		courseDao.save(course2);

		Instructor instructor = new Instructor("MD RAHIM", "Hassan",
				"abc@def.com");
		instructor.setInstructorDetail(new InstructorDetail("youtube.com", "TRAVELLING"));

		instructorDao.save(instructor);

		Course course3 = new Course("Course3_" + Math.random()*5);

		course3.setInstructor(instructor);

		courseDao.save(course3);
	}

	@Test
	public void updateInstructor(){
		Optional<Instructor> instructorDaoById = instructorDao.findById(13l);

		if(instructorDaoById.isEmpty()){
			return;
		}

		Instructor instructor = instructorDaoById.get();

		instructor.setLastName("TESTER");

		instructorDao.save(instructor);
	}

	@Test
	public void updateCourse(){
		Optional<Instructor> instructorDaoById = instructorDao.findById(13l);

		if(instructorDaoById.isEmpty()){
			return;
		}

		Optional<Course> courseDaoById = courseDao.findById(14l);

		if(courseDaoById.isEmpty()){
			return;
		}

		Course course = courseDaoById.get();

		course.setTitle("Funny");
		course.setInstructor(instructorDao.findById(6l).get());
		courseDao.save(course);

	}

	@Test
	@Transactional
	void deleteInstructorById(){
		Optional<Instructor> instructorDaoById = instructorDao.findById(2l);

		if(instructorDaoById.isEmpty()){
			return;
		}

		Instructor instructor = instructorDaoById.get();

		List<Course> courses = instructor.getCourses();

		//System.out.println(instructor);

		for(Course course : courses){
			course.setInstructor(null);

		}
		System.out.println(courses);
		courseDao.saveAll(courses);

		instructorDao.delete(instructor);




	}

}

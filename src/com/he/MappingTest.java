package com.he;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.he.dto.Course;
import com.he.dto.Students;

public class MappingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Students  students  = new Students();
		
		students.setStudentName("Ram");
		
		Course  course = new Course();
		course.setCourseName("Dot Net");
		
		Course  course1 = new Course();
		course1.setCourseName("Android");
		
		students.getCourse().add(course);
		students.getCourse().add(course1);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		session.save(students);
		session.save(course);
		session.save(course1);
		session.getTransaction().commit();	
	}

}

package com.he;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.he.dto.Address;
import com.he.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		// 1. instance of entity class
		UserDetails ud = new UserDetails();
		
		
		ud.setUserName("Raju");
		ud.setEmail("raju@gmail.com");
		ud.setMobile("9751270433");
		
		Address address = new Address();
		address.setStreet("Street");
		address.setCity("Hyderabad");
		address.setState("Telangana");
		address.setPincode("500043");		
		
		Address address1 = new Address();
		address1.setStreet("Street");
		address1.setCity("Hyderabad");
		address1.setState("Telangana");
		address1.setPincode("500043");		
		
		ud.getListOfAddresses().add(address);
		ud.getListOfAddresses().add(address1);
		
				
		
		//2. sessionFactory object to configuration
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(ud);	
		session.getTransaction().commit();	
		
		//Retriving data from database
		session = sessionFactory.openSession();
		ud = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User Name : "+ud.getUserName() );

	}

}

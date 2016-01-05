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
		
		
		ud.setUserName("Ram");
		ud.setEmail("ram@gmail.com");
		ud.setMobile("9651270433");
		
		Address address = new Address();
		address.setStreet("Street1");
		address.setCity("Hyderabad1");
		address.setState("Telangana1");
		address.setPincode("500042");		
		
		Address address1 = new Address();
		address1.setStreet("Street2");
		address1.setCity("Hyderabad2");
		address1.setState("Telangana3");
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
		ud = (UserDetails)session.get(UserDetails.class, 2);
		session.close();
		System.out.println("address : "+ud.getListOfAddresses().size());
	}

}

package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class EmployeeManager {
	
	public String addEmployee(Employee E) throws Exception{
		
		SessionFactory SF = new Configuration().configure().buildSessionFactory();
		Session S = SF.openSession();
		
		S.getTransaction().begin();
		S.persist(E);
		S.getTransaction().commit();

		S.close();
		SF.close();
		
		return "Client data has been saved";
	}

}
package onetomany_uni_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany_uni_dto.Employee;

public class EmployeeDao {
	Scanner scanner=new Scanner(System.in);
public EntityManager getEntityManager() {
		
		EntityManagerFactory emfEntityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=emfEntityManagerFactory.createEntityManager();
		return entityManager;
		
	}
public void saveEmployee(Employee employee) {
	EntityManager  entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	System.out.println("Enter the name of employee");
	String ename=scanner.next();
	System.out.println("Enter the employee address");
	String address=scanner.next();
	System.out.println("Enter the phone number");
	long phone=scanner.nextLong();
	
	Employee employee1=new Employee();
	List<Employee>l=new ArrayList<Employee>();
	l.add(employee1);
	
	employee1.setName(ename);
	employee1.setAddress(address);
	employee1.setPhone(phone);


	entityTransaction.begin();
	
	for(Employee e:l) {
		entityManager.persist(e);
	}
	entityTransaction.commit();
}

}

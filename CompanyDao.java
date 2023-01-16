package onetomany_uni_dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import onetomany_uni_dto.Company;
import onetomany_uni_dto.Employee;

public class CompanyDao {
	
	Scanner scanner=new Scanner(System.in);
	
	
	public EntityManager getEntityManager() {
		
		EntityManagerFactory emfEntityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=emfEntityManagerFactory.createEntityManager();
		return entityManager;
		
	}
	
	
	public void saveCompany(Company company) {
		EntityManager  entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
	
		System.out.println("Enter the name of the company name");
		String name=scanner.next();
		System.out.println("Enter the gst of company");
		String gst=scanner.next();
		company.setName(name);
		company.setGst(gst);
	
		
		
		System.out.println("Enter the name of employee");
		String ename=scanner.next();
		System.out.println("Enter the employee address");
		String address=scanner.next();
		System.out.println("Enter the phone number");
		long phone=scanner.nextLong();
		Employee employee=new Employee();
		List<Employee>l=new ArrayList<Employee>();
		l.add(employee);
		
		employee.setName(ename);
		employee.setAddress(address);
		employee.setPhone(phone);
		company.setList(l);
	
		entityTransaction.begin();
		entityManager.persist(company);
		for(Employee e:l) {
			entityManager.persist(e);
		}
		entityTransaction.commit();
	}
	
	public void updateCompany(int id,Company company) {
		EntityManager  entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
	//	
		Company recivedCompany=entityManager.find(Company.class, id);
		System.out.println("Enter the name to update");
		String name=scanner.next();
		
		if(recivedCompany!=null) {
			company.setId(id);
			company.setName(name);
			company.setList(recivedCompany.getList());
			entityTransaction.begin();
			entityManager.merge(company);
		//	entityManager.merge(recivedCompany);
			entityTransaction.commit();
		}
		else {
			System.out.println("Employee details not exist");
		}
		
	}
	
public void deleteCompany(int id)
	
	{
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Company recivedCompany=entityManager.find(Company.class, id);
		if (recivedCompany != null) {
			entityTransaction.begin();
			entityManager.remove(recivedCompany);
			entityTransaction.commit();
		}else {
			System.out.println("not found");
		}
		
	}

public void findById(int id)
{
	EntityManager entityManager=getEntityManager();
	Company recivedCompany=entityManager.find(Company.class, id);
	System.out.println(recivedCompany);
	
	
}

public void findAll()
{
	
	EntityManager entityManager=getEntityManager();
	Query query=entityManager.createQuery("select c from Company c");
	List<Company>list=query.getResultList();
	System.out.println(list);
	
}
	
	
	

}

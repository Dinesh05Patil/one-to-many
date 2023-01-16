package onetomany_uni_controller;

import java.util.Scanner;

import onetomany_uni_dao.CompanyDao;
import onetomany_uni_dto.Company;
import onetomany_uni_dto.Employee;

public class CompanyCRUDMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		CompanyDao companyDao = new CompanyDao();
		boolean flag=true;
		
		
		do {
		System.out.println("Enter your choice \n 1.save \n 2.update \n 3.delete \n 4.getbyid \n 5.getall \n 6.exit");
		int ch = scanner.nextInt();

		switch (ch) {
		case 1: {

			companyDao.saveCompany(new Company());

		}break;
			

		case 2: {
			
			System.out.println("Enter the id to be set");
			int id=scanner.nextInt();
			companyDao.updateCompany(id, new Company());

		}break;
		
	case 3: {
			
			System.out.println("Enter the id to be deleted");
			int id=scanner.nextInt();
			companyDao.deleteCompany(id);

		}break;
		
	case 4: {
		
		System.out.println("Enter the id to get details");
		int id=scanner.nextInt();
		companyDao.findById(id);

	}break;
	
case 5: {
		
	
		companyDao.findAll();

	}break;

case 6:{
			flag=false;
		}
			break;
		}

	}while(true);
	}

}

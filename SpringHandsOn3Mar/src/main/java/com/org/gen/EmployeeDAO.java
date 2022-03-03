package com.org.gen;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {

	
    private static Employees list = new Employees();


		static
		{
		    list.getEmployeeList().add(new Employee(1,"Ramanuj","Mishra","ramanju@gmail.com"));
		
		    list.getEmployeeList().add(new Employee(2,"anuj","Kumar","anuj@gmail.com"));
		
		    list.getEmployeeList().add(new Employee(3, "keshav","Singh","ksingh@gmail.com"));
		
		       
		}

		
		public Employees getAllEmployees()
		{
		
		    return list;
		}

	    public void addEmployee(Employee employee)
		{
		    list.getEmployeeList()
		        .add(employee);
		       
		}
	
	
}

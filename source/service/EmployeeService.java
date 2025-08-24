package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {
	//create
		public boolean addEmployee(Employee employee);
		
		//read
		public List<Employee> findAll();
		public Employee findById(int id);
		public Employee findByUsername(String username);
		public Employee Employeelogin(String username,String password);
		
		//update
		public boolean updateData(Employee employee);
		
		//delete
		public boolean deleteData(Employee employee) ;
}

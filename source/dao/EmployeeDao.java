package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	//create
	public void addEmployee(Employee employee);
	
	//read
	public List<Employee> selectAll();
	public Employee selectById(int id);
	public Employee selectByUsername(String username);
	public Employee select(String username,String password);
	
	//update
	public void update(Employee employee);
	
	//delete
	public void delete(Employee employee) ;
}

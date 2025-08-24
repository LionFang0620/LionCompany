package service.impl;

import java.util.List;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import model.Member;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDaoImpl edi=new EmployeeDaoImpl();
	
	@Override
	public boolean addEmployee(Employee employee) {
		boolean isUsed=false;
		Employee em=edi.selectByUsername(employee.getUsername());
		if(em==null)
		{
			edi.addEmployee(employee);
			isUsed=true;
		}
		return isUsed;
		
	}

	@Override
	public List<Employee> findAll() {
		
		return edi.selectAll();
	}

	@Override
	public Employee findById(int id) {
		
		return edi.selectById(id);
	}

	@Override
	public Employee findByUsername(String username) {
		
		return edi.selectByUsername(username);
	}

	@Override
	public Employee Employeelogin(String username, String password) {
		
		return edi.select(username, password);
	}

	@Override
	public boolean updateData(Employee employee) {
		Employee e=edi.selectById(employee.getId());
		boolean x=false;
		if(e!=null)
		{
			x=true;
			edi.update(employee);
		}
		return x;
		
	}

	@Override
	public boolean deleteData(Employee employee) {
		Employee e=edi.selectById(employee.getId());
		boolean x=false;
		if(e!=null)
		{
			x=true;
			edi.delete(employee);
		}
		return x;
	}
	

}

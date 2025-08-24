package dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.EmployeeDao;
import model.Employee;
import util.DbConnection;

public class EmployeeDaoImpl implements EmployeeDao {
	
	public static Connection conn=DbConnection.getDb();
	@Override
	public void addEmployee(Employee employee) {
		String sql="insert into Employee(name,username,password) Value(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,employee.getName());
			ps.setString(2,employee.getUsername());
			ps.setString(3,employee.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Employee> selectAll() {
		List<Employee> list=new ArrayList<>();
		String sql="select * from employee";
		try {
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Employee selectById(int id) {
		String sql="select * from employee where id=?";
		Employee employee=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	
	@Override
	public Employee selectByUsername(String username) {
		String sql="select * from employee where username=?";
		Employee employee=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
	

	@Override
	public Employee select(String username, String password) {
		String sql="select * from employee where username=? and password=?";
		Employee employee=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				employee=new Employee();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}


	@Override
	public void update(Employee employee) {
		String sql="update employee set name=?,password=? "
				+ "where username=?";
		try 
		{
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,employee.getName());
			ps.setString(2,employee.getPassword());
			ps.setString(3,employee.getUsername());
			ps.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Employee employee) {
		String sql="delete from employee where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,employee.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	



}

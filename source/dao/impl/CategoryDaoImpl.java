package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CategoryDao;
import model.Category;
import util.DbConnection;

public class CategoryDaoImpl implements CategoryDao{

	public static void main(String[] args) {
		/*Category c=new Category("限時特價");
		new CategoryDaoImpl().addCategory(c);
		System.out.println("新增完成");*/
		
		//CategoryDaoImpl cdi=new CategoryDaoImpl();
		List<Category> list=new CategoryDaoImpl().selectAll();
		for(Category o:list)
		{
			System.out.println(o.getId()+"  "+o.getName());
		}
		
		/*if(c!=null) 
		{
			//c.setName("時令蔬菜");
			cdi.deleteCategory(c);
			System.out.println("刪除完成");
		}
		else
		{
			System.out.println("刪除失敗");
		}*/
		
	}

	public static Connection conn=DbConnection.getDb();
	@Override
	public void addCategory(Category category) {
		String sql="insert into category(name) Values(?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,category.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Category selectById(int id) {
		String sql="select * from category where id=?";
		Category category=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				category=new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
	
	@Override
	public Category selectByName(String name) {
		String sql="select * from category where name=?";
		Category category=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				category=new Category();
				category.setId(rs.getInt("id"));
				category.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}
	
	@Override
	public List<Category> selectAll() {
		String sql="select * from category";
		List<Category> list=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Category c=new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void updateCategory(Category category) {
		String sql="update category set name=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,category.getName());
			ps.setInt(2,category.getId() );
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteCategory(Category category) {
		String sql="delete from category where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,category.getId() );
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

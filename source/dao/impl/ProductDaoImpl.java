package dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ProductDao;
import model.Product;
import util.DbConnection;

public class ProductDaoImpl implements ProductDao {

	Connection conn=DbConnection.getDb();
	@Override
	public void addProduct(Product product) {
		String sql="insert into product(category_id,name,price) "
				+ "Values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,product.getCategoryId());
			ps.setString(2,product.getName());
			ps.setInt(3,product.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> selectAll() {
		String sql="select * from product";
		List<Product> list=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setCategoryId(rs.getInt("category_id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product selectById(int id) {
		String sql="select * from product where id=?";
		Product product=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				product=new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setCategoryId(rs.getInt("category_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> selectByCategoryId(int category_id) {
		String sql="select * from product where category_id=?";
		List<Product> list=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,category_id );
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setCategoryId(rs.getInt("category_id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public void updateProduct(Product product) {
	String sql="update product set category_id=?, name=?,price=? where id=?";
	try {
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1,product.getCategoryId());
		ps.setString(2,product.getName());
		ps.setInt(3,product.getPrice());
		ps.setInt(4,product.getId());
		ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void deleteProduct(Product product) {
		String sql="delete from product where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,product.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}

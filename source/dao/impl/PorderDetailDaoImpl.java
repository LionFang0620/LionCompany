package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDetailDao;
import model.PorderDetail;
import util.DbConnection;

public class PorderDetailDaoImpl implements PorderDetailDao{

	Connection conn=DbConnection.getDb();
	@Override
	public void addPorderDetail(PorderDetail porderDetail) {
		String sql="insert into porderdetail(porder_id,category_id,product_id"
				+ ",product_name,quantity) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,porderDetail.getPorderId());
			ps.setInt(2,porderDetail.getCategoryId());
			ps.setInt(3,porderDetail.getProductId());
			ps.setString(4,porderDetail.getProductName());
			ps.setInt(5,porderDetail.getQuantity());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PorderDetail> selectAll() {
		List<PorderDetail> list=new ArrayList<>();
		String sql="select * from porderdetail";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PorderDetail pd=new PorderDetail();
				pd.setId(rs.getInt("id"));
				pd.setPorderId(rs.getInt("porder_id"));
				pd.setCategoryId(rs.getInt("category_id"));
				pd.setProductId(rs.getInt("product_id"));
				pd.setProductName(rs.getString("product_name"));
				pd.setQuantity(rs.getInt("quantity"));
				list.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PorderDetail> selectByCategoryId(int categoryid) {
		List<PorderDetail> list=new ArrayList<>();
		String sql="select * from porderdetail where category_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, categoryid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PorderDetail pd=new PorderDetail();
				pd.setId(rs.getInt("id"));
				pd.setPorderId(rs.getInt("porder_id"));
				pd.setCategoryId(rs.getInt("category_id"));
				pd.setProductId(rs.getInt("product_id"));
				pd.setProductName(rs.getString("product_name"));
				pd.setQuantity(rs.getInt("quantity"));
				list.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<PorderDetail> selectByPorderId(int porderid) {
		 List<PorderDetail> list = new ArrayList<>();
		 String sql="select * from porderdetail where porder_id=?";
		    try (PreparedStatement ps = conn.prepareStatement(sql)) {
		        ps.setInt(1, porderid);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		        	PorderDetail pd=new PorderDetail();
					pd.setId(rs.getInt("id"));
					pd.setPorderId(rs.getInt("porder_id"));
					pd.setCategoryId(rs.getInt("category_id"));
					pd.setProductId(rs.getInt("product_id"));
					pd.setProductName(rs.getString("product_name"));
					pd.setQuantity(rs.getInt("quantity"));
					list.add(pd);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return list;
	}

	@Override
	public List<PorderDetail> selectByProductId(int productid) {
		List<PorderDetail> list=new ArrayList<>();
		String sql="select * from porderdetail where product_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, productid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				PorderDetail pd=new PorderDetail();
				pd.setId(rs.getInt("id"));
				pd.setPorderId(rs.getInt("porder_id"));
				pd.setCategoryId(rs.getInt("category_id"));
				pd.setProductId(rs.getInt("product_id"));
				pd.setProductName(rs.getString("product_name"));
				pd.setQuantity(rs.getInt("quantity"));
				list.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PorderDetail selectById(int id) {
		String sql="select * from porderdetail where id=?";
		PorderDetail pd=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				pd=new PorderDetail();
				pd.setId(rs.getInt("id"));
				pd.setPorderId(rs.getInt("porder_id"));
				pd.setCategoryId(rs.getInt("category_id"));
				pd.setProductId(rs.getInt("product_id"));
				pd.setProductName(rs.getString("product_name"));
				pd.setQuantity(rs.getInt("quantity"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pd;
	}

	@Override
	public void updatePorderDetail(PorderDetail porderDetail) {
		String sql="update porderdetail set porder_id=?,category_id=?"
				+ ",product_id=?,product_name=?,quantity=? "
				+ "where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,porderDetail.getPorderId());
			ps.setInt(2,porderDetail.getCategoryId());
			ps.setInt(3,porderDetail.getProductId());
			ps.setString(4,porderDetail.getProductName());
			ps.setInt(5,porderDetail.getQuantity());
			ps.setInt(6, porderDetail.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deletePorderDetail(PorderDetail porderDetail) {
		String sql="delete from porderdetail where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,porderDetail.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DbConnection;

public class PorderDaoImpl implements PorderDao {

	Connection conn=DbConnection.getDb();
	@Override
	public void addPorder(Porder porder) {
		String sql="insert into porder(porder_id,porder_time,member_id,total) "
				+ "value(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,porder.getPorderId());
			ps.setString(2,porder.getPorderTime());
			ps.setInt(3,porder.getMemberId());
			ps.setInt(4,porder.getTotal());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectAll() {
		List<Porder> list=new ArrayList<>();
		String sql="select * from porder";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setPorderTime(rs.getString("porder_time"));
				p.setMemberId(rs.getInt("member_id"));
				p.setTotal(rs.getInt("total"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Porder> selectByMemberId(int memberid) {
		List<Porder> list=new ArrayList<>();
		String sql="select * from porder where member_id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, memberid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Porder p=new Porder();
				p.setId(rs.getInt("id"));
				p.setPorderTime(rs.getString("porder_time"));
				p.setMemberId(rs.getInt("member_id"));
				p.setTotal(rs.getInt("total"));
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Porder selectById(int id) {
		String sql="select * from porder where id=?";
		Porder p=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				p=new Porder();
				p.setId(rs.getInt("id"));
				p.setPorderTime(rs.getString("porder_time"));
				p.setMemberId(rs.getInt("member_id"));
				p.setTotal(rs.getInt("total"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void updatePorder(Porder porder) {
		String sql="update porder set porder_time=?,member_id=?,total=? where id=?" ;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,porder.getPorderTime());
			ps.setInt(2,porder.getMemberId());
			ps.setInt(3,porder.getTotal());
			ps.setInt(4,porder.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deletePorder(Porder porder) {
		String sql="delete from porder where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1,porder.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String findMaxPorderId() {
		 String sql = "SELECT MAX(porder_id) FROM porder";
		    try {
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
		        if (rs.next() && rs.getString(1) != null) {
		            return rs.getString(1);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		return null;
	}

}

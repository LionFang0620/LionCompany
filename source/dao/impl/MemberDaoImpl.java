package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao {

	public static Connection conn=DbConnection.getDb();
	@Override
	public void addMember(Member member) {
		String sql="insert into member(name,username,password,address,phone) "
				+ "Value(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getUsername());
			ps.setString(3,member.getPassword());
			ps.setString(4,member.getAddress());
			ps.setString(5,member.getPhone());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Member select(String username, String password) {
		Member member=null;
		String sql="select * from member where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				 member=new Member();
				 member.setId(rs.getInt("id"));
				 member.setName(rs.getString("name"));
				 member.setUsername(rs.getString("username"));
				 member.setPassword(rs.getString("password"));
				 member.setAddress(rs.getString("address"));
				 member.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return member;
	}
	
	@Override
	//做為修改會員與刪除會員的索引
	//由使用者輸入帳號
	public Member selectUser(String username) {
		Member member=null;
		String sql="select * from member where username=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				member=new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setUsername(rs.getString("username"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public void update(Member member) {
		String sql="update member set name=?,password=?,address=?,phone=? "
				+ "where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,member.getName());
			ps.setString(2,member.getPassword());
			ps.setString(3,member.getAddress());
			ps.setString(4,member.getPhone());
			ps.setString(5,member.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(Member member) {
		String sql="Delete from member where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,member.getUsername());
			ps.setString(2,member.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}

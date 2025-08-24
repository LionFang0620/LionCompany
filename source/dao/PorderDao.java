package dao;

import java.util.List;

import model.Porder;

public interface PorderDao {
	//create
		public void addPorder(Porder porder);//新增訂單
		
		//read
		public List<Porder> selectAll();
		public List<Porder> selectByMemberId(int memberid);//根據會員帳號查詢訂單
		public Porder selectById(int id);//根據訂單ID，可以刪除訂單或是修改訂單
		
		//update
		public void updatePorder(Porder porder);//更新訂單
		
		//delete
		public void deletePorder(Porder porder);//刪除訂單
		
		//產生編號
		public String findMaxPorderId();
}

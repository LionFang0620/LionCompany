package service;

import java.util.List;

import model.Porder;
import model.PorderDetail;

public interface PorderDetailService {
	//create
	public boolean addPorder(PorderDetail porderDetail);
	
	//read
	public List<PorderDetail> findAll();
	public List<PorderDetail> findByCategoryId(int categoryid);//根據分類ID查詢訂單詳細
	public List<PorderDetail> findByPorderId(int porderid);//根據訂單編號查詢訂單詳細
	public List<PorderDetail> findByProductId(int productid);//根據產品編號查詢訂單詳細
	public PorderDetail findById(int id);//根據詳細訂單ID，可以刪除詳細訂單或是修改詳細訂單
	
	//update
	boolean updatePorder(PorderDetail porderDetail);
			
	//delete
	boolean deletePorder(PorderDetail porderDetail);

}

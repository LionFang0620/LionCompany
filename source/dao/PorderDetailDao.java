package dao;

import java.util.List;
import model.PorderDetail;

public interface PorderDetailDao {
	//create
	void addPorderDetail(PorderDetail porderDetail); //新增訂單詳細
	
	//read
	public List<PorderDetail> selectAll();
	public List<PorderDetail> selectByCategoryId(int categoryid);//根據分類ID查詢訂單詳細
	public List<PorderDetail> selectByPorderId(int porderid);//根據訂單編號查詢訂單詳細
	public List<PorderDetail> selectByProductId(int productid);//根據產品編號查詢訂單詳細
	public PorderDetail selectById(int id);//根據詳細訂單ID，可以刪除詳細訂單或是修改詳細訂單
	
	//update
	public void updatePorderDetail(PorderDetail porderDetail);//更新詳細訂單
	
	//delete
	public void deletePorderDetail(PorderDetail porderDetail);//刪除詳細訂單
}

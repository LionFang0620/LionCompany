package service.impl;

import java.util.List;

import dao.impl.PorderDetailDaoImpl;
import model.Porder;
import model.PorderDetail;
import model.Product;
import service.PorderDetailService;

public class PorderDetailServiceImpl implements PorderDetailService {
	
	PorderDetailDaoImpl pddi=new PorderDetailDaoImpl();
	@Override
	public boolean addPorder(PorderDetail porderDetail) {
		boolean isUsed=false;
		PorderDetail p=pddi.selectById(porderDetail.getId());
		if(p==null)
		{
			pddi.addPorderDetail(porderDetail);
			isUsed=true;
		}
		return isUsed;
	}

	@Override
	public List<PorderDetail> findAll() {
		
		return pddi.selectAll();
	}

	@Override
	public List<PorderDetail> findByCategoryId(int categoryid) {
		
		return pddi.selectByCategoryId(categoryid);
	}

	@Override
	public List<PorderDetail> findByPorderId(int porderid) {
		
		return pddi.selectByPorderId(porderid);
	}

	@Override
	public List<PorderDetail> findByProductId(int productid) {
		
		return pddi.selectByProductId(productid);
	}

	@Override
	public PorderDetail findById(int id) {
		
		return pddi.selectById(id);
	}

	@Override
	public boolean updatePorder(PorderDetail porderDetail) {
		PorderDetail p=pddi.selectById(porderDetail.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pddi.updatePorderDetail(porderDetail);;
		}
		return x;
	}

	@Override
	public boolean deletePorder(PorderDetail porderDetail) {
		PorderDetail p=pddi.selectById(porderDetail.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pddi.deletePorderDetail(porderDetail);;
		}
		return x;
	}

}

package service.impl;

import java.util.List;

import dao.impl.PorderDaoImpl;
import model.Porder;
import model.Product;
import service.PorderService;

public class PorderServiceImpl implements PorderService{
	
	PorderDaoImpl pdi=new PorderDaoImpl();
	
	@Override
	public boolean addPorder(Porder porder) {
		boolean isUsed=false;
		Porder p=pdi.selectById(porder.getId());
		if(p==null)
		{
			pdi.addPorder(porder);
			isUsed=true;
		}
		return isUsed;
	}

	@Override
	public List<Porder> findAllPorder() {
		
		return pdi.selectAll();
	}

	@Override
	public List<Porder> findByMemberId(int memberid) {
		
		return pdi.selectByMemberId(memberid);
	}

	@Override
	public Porder findById(int id) {
		
		return pdi.selectById(id);
	}

	@Override
	public boolean updatePorder(Porder porder) {
		Porder p=pdi.selectById(porder.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pdi.updatePorder(porder);
		}
		return x;
	}

	@Override
	public boolean deletePorder(Porder porder) {
		Porder p=pdi.selectById(porder.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pdi.deletePorder(porder);
		}
		return x;
	}

	@Override
	public String generatePorderId() {
		String lastId = pdi.findMaxPorderId();
        if (lastId == null) 
        {
            return "P001";
        }
        int num = Integer.parseInt(lastId.substring(1)) + 1;
        return String.format("P%03d", num);
	}
	

}

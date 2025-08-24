package service;

import java.util.List;

import model.Porder;

public interface PorderService {
		//create
		public boolean addPorder(Porder porder);
		
		//read
		public List<Porder> findAllPorder();
		public List<Porder> findByMemberId(int memberid);
		public Porder findById(int id);
		
		
		//update
		boolean updatePorder(Porder porder);
		
		//delete
		boolean deletePorder(Porder porder);
		
		//產生編號
		public String generatePorderId();

}

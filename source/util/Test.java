package util;

import java.util.List;

import dao.impl.CategoryDaoImpl;
import dao.impl.EmployeeDaoImpl;
import dao.impl.MemberDaoImpl;
import dao.impl.PorderDaoImpl;
import dao.impl.PorderDetailDaoImpl;
import dao.impl.ProductDaoImpl;
import model.Category;
import model.Employee;
import model.Member;
import model.Porder;
import model.PorderDetail;
import model.Product;

public class Test {

	public static void main(String[] args) {
		CategoryDaoImpl cdi=new CategoryDaoImpl();
		MemberDaoImpl mdi=new MemberDaoImpl();
		PorderDaoImpl pdi=new PorderDaoImpl();
		PorderDetailDaoImpl pddi=new PorderDetailDaoImpl();
		/*Category c=new Category("生鮮食材");
		cdi.addCategory(c);
		System.out.println("新增成功！");*/
		
		/*Member m=new Member("Cativ","userc","3333","USA","0987");
		mdi.addMember(m);*/
		
		/*PorderDetail pd=new PorderDetail(4,2,6,"奧利奧餅乾",10);
		pddi.addPorderDetail(pd);*/
		
		PorderDetail pd=pddi.selectById(6);
		if(pd!=null)
		{
			
			pddi.deletePorderDetail(pd);
			System.out.println("刪除成功");
		}
		else
		{
			System.out.println("沒有這筆訂單");
		}
		
			
				
		
		/*Porder p=pdi.selectById(5);
		if(p!=null)
		{
			
			pdi.deletePorder(p);
			System.out.println("刪除完成");
		}
		else 
		{
		    System.out.println("查無訂單資料");
		}*/
		/*Porder p=new Porder(2,600);
		pdi.addPorder(p);
		System.out.println("新增成功");
		
		List<Porder> p=pdi.selectByMemberId(2);
		if (p == null || p.isEmpty()) 
		{
			    System.out.println("沒有訂購資料");
		} 
		else 
		{
		for (Porder o : p) 
			{
				System.out.println("ID：" + o.getId()
			                  + "\t訂單時間：" + o.getPorderTime()
			                  + "\t會員ID：" + o.getMemberId());
			}
		}*/

}
}

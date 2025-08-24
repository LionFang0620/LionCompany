package service.impl;

import java.util.List;

import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;

public class ProductServiceImpl implements ProductService{

	ProductDaoImpl pdi=new ProductDaoImpl();
	@Override
	public boolean addProduct(Product product) {
		boolean isUsed=false;
		Product p=pdi.selectById(product.getId());
		if(p==null)
		{
			pdi.addProduct(product);
			isUsed=true;
		}
		return isUsed;
	}

	@Override
	public Product selectById(int id) {
		// TODO Auto-generated method stub
		return pdi.selectById(id);
	}

	@Override
	public List<Product> findAllProduct() {
		
		return pdi.selectAll();
	}
	
	@Override
	public List<Product> findByCategoryId(int categoryid) {
		
		return pdi.selectByCategoryId(categoryid);
	}

	@Override
	public boolean updateProduct(Product product) {
		Product p=pdi.selectById(product.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pdi.updateProduct(product);
		}
		return x;
		
	}

	@Override
	public boolean deleteProduct(Product product) {
		Product p=pdi.selectById(product.getId());
		boolean x=false;
		if(p!=null)
		{
			x=true;
			pdi.deleteProduct(product);
		}
		return x;
	}



}

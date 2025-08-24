package dao;

import java.util.List;
import model.Product;

public interface ProductDao {
	//create
	public void addProduct(Product product);
	
	//read
	public List<Product> selectAll();
	public Product selectById(int id);
	public List<Product>selectByCategoryId(int category_id);
	
	//update
	public void updateProduct(Product product);
	
	//delete
	void deleteProduct(Product product);


}

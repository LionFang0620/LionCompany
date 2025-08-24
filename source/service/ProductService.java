package service;

import java.util.List;
import model.Product;

public interface ProductService {
	//create
		public boolean addProduct(Product product);
		
		//read
		public Product selectById(int id);
		public List<Product> findAllProduct();
		public List<Product> findByCategoryId(int categoryid);
		
		//update
		public boolean updateProduct(Product product);
		
		//delete
		public boolean deleteProduct(Product product);

}

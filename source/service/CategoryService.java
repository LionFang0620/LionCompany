package service;

import java.util.List;

import model.Category;

public interface CategoryService {
	
	//create
	public boolean addCategory(Category category);
	
	//read
	public Category selectById(int id);
	public List<Category> findAllCategory();
	
	//update
	public boolean updateCategory(Category category);
	
	//delete
	public boolean deleteCategory(Category category);

}

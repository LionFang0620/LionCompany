package dao;

import java.util.List;

import model.Category;

public interface CategoryDao {
	//create
	public void addCategory(Category category);
	
	//read
	public Category selectById(int id);
	public Category selectByName(String name);
	public List<Category> selectAll();
	
	//update
	public void updateCategory(Category category);
	
	//delete
	void deleteCategory(Category category);
	

}

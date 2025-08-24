package service.impl;

import java.util.List;

import dao.impl.CategoryDaoImpl;
import model.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	CategoryDaoImpl cdi=new CategoryDaoImpl();
	@Override
	public boolean addCategory(Category category) {
		boolean isUsed=false;
		Category c=cdi.selectByName(category.getName());
		if(c==null)
		{
			cdi.addCategory(category);
			isUsed=true;
		}
		return isUsed;
		
	}

	@Override
	public Category selectById(int id) {
		
		return cdi.selectById(id);
	}

	@Override
	public List<Category> findAllCategory() {
		
		return cdi.selectAll();
	}

	@Override
	public boolean updateCategory(Category category) {
		boolean isUsed=false;
		Category c=cdi.selectByName(category.getName());
		if(c==null)
		{
			cdi.updateCategory(category);
			isUsed=true;
		}
		return isUsed;
	}

	@Override
	public boolean deleteCategory(Category category) {
		Category c=cdi.selectById(category.getId());
		boolean x=false;
		if(c!=null)
		{
			x=true;
			cdi.deleteCategory(category);
		}
		return x;
	}

}

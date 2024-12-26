package com.cerena.service;

import com.cerena.entity.Category;
import com.cerena.entity.User;
import com.cerena.repository.CategoryRepository;
import com.cerena.repository.RepositoryManager;

import java.util.List;

public class CategoryService extends ServiceManager<Category, Long> {
	private final CategoryRepository categoryRepository;
	
	public CategoryService(RepositoryManager<Category, Long> repository, CategoryRepository categoryRepository) {
		super(repository);
		this.categoryRepository = categoryRepository;
	}
	
	public Category createCategory(String name, Long parentCategoryid){
		Category category = Category.builder()
		                            .name(name)
		                            .parentCategoryid(parentCategoryid)
		                            .build();
        return categoryRepository.save(category);
		
	}
	
	public Category updateCategory(Long id, String name, Long parentCategoryid){
		Category category = categoryRepository.findById(id)
                                            .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
        category.setName(name);
        category.setParentCategoryid(parentCategoryid);
        return categoryRepository.save(category);
	}
	
	public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
	
	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category findCategoryById(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}
	
	
	
}
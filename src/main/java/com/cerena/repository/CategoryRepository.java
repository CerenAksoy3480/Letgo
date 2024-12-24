package com.cerena.repository;

import com.cerena.entity.Category;
import com.cerena.entity.User;

public class CategoryRepository extends RepositoryManager<Category, Long> {
	public CategoryRepository() {
		super(Category.class);
	}
}
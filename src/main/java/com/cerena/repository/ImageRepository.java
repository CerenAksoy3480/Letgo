package com.cerena.repository;

import com.cerena.entity.Category;
import com.cerena.entity.Image;

public class ImageRepository extends RepositoryManager<Image, Long> {
	public ImageRepository(Class<Image> entityClass) {
		super(entityClass);
	}
}
package com.cerena.service;

import com.cerena.entity.Image;
import com.cerena.entity.User;
import com.cerena.repository.ImageRepository;
import com.cerena.repository.RepositoryManager;

public class ImageService extends ServiceManager<Image, Long> {
	private final ImageRepository imageRepository;
	
	public ImageService(RepositoryManager<Image, Long> repository, ImageRepository imageRepository) {
		super(repository);
		this.imageRepository = imageRepository;
	}
}
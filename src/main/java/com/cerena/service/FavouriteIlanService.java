package com.cerena.service;

import com.cerena.entity.FavouriteIlan;
import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import com.cerena.repository.FavouriteIlanRepository;
import com.cerena.repository.RepositoryManager;

import java.util.List;

public class FavouriteIlanService extends ServiceManager<FavouriteIlan, Long> {
	private final FavouriteIlanRepository favouriteIlanRepository;
	
	public FavouriteIlanService(RepositoryManager<FavouriteIlan, Long> repository, FavouriteIlanRepository favouriteIlanRepository) {
		super(repository);
		this.favouriteIlanRepository = favouriteIlanRepository;
	}
	
	public List<Ilan> findByUserId(long userId) {
		User user = new User();
		user.setId(userId);
		return favouriteIlanRepository.findByUser(user);
	}
}
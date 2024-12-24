package com.cerena.repository;

import com.cerena.entity.FavouriteIlan;
import com.cerena.entity.User;

public class FavouriteIlanRepository extends RepositoryManager<FavouriteIlan, Long> {
	public FavouriteIlanRepository(Class<FavouriteIlan> entityClass) {
		super(entityClass);
	}
}
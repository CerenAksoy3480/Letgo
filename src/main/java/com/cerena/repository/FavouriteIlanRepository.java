package com.cerena.repository;

import com.cerena.entity.FavouriteIlan;

public class FavouriteIlanRepository extends RepositoryManager<FavouriteIlan, Long> {
	public FavouriteIlanRepository() {
		super(entityClass);
	}
}
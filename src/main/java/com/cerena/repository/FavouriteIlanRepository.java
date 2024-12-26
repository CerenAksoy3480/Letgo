package com.cerena.repository;

import com.cerena.entity.FavouriteIlan;
import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import jakarta.persistence.EntityManager;

import java.util.List;

public class FavouriteIlanRepository extends RepositoryManager<FavouriteIlan, Long> {
	
	
	private EntityManager em;
	
	
	public FavouriteIlanRepository(EntityManager em) {
		super(FavouriteIlan.class);
		this.em = em;
	}
	public FavouriteIlanRepository() {
		super(FavouriteIlan.class);
		
	}
	
	public List<Ilan> findByUser(User user) {
		return em.createQuery("select i from Ilan i where i.user = :user", Ilan.class)
		         .setParameter("user", user)
		         .getResultList();
	}
}
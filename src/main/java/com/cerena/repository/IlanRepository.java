package com.cerena.repository;

import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class IlanRepository extends RepositoryManager<Ilan, Long> {
	
	private EntityManager em;
	
	
	public IlanRepository() {
		super(Ilan.class);
		this.em = em;
	}
	
	public List<Ilan> findByCategory(long category) {
		return em.createQuery("select i from Ilan i where i.category.id = :category", Ilan.class)
		         .setParameter("category", category)
		         .getResultList();
		
	}
	
	public List<Ilan> findByLocation(String location) {
		return em.createQuery("select i from Ilan i where i.location = :location", Ilan.class)
                 .setParameter("location", location)
                 .getResultList();
	}

	public List<Ilan> findByDateRage(LocalDate startDate, LocalDate endDate) {
		return em.createQuery("select i from Ilan i where i.createAt >= :startDate and i.createAt <= :endDate", Ilan.class)
                 .setParameter("startDate", startDate)
                 .setParameter("endDate", endDate)
                 .getResultList();
	}
	
	public List<Ilan> findByUser(User user) {
		return em.createQuery("select i from Ilan i where i.user = :user", Ilan.class)
		         .setParameter("user", user)
		         .getResultList();
    }
	
	

	
}
package com.cerena.repository;

import com.cerena.entity.Ilan;
import com.cerena.entity.User;

public class IlanRepository extends RepositoryManager<Ilan, Long> {
	public IlanRepository(Class<Ilan> entityClass) {
		super(entityClass);
	}
}
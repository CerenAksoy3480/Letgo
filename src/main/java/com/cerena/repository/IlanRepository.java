package com.cerena.repository;

import com.cerena.entity.Ilan;

public class IlanRepository extends RepositoryManager<Ilan, Long> {
	public IlanRepository() {
		super(Ilan.class);
	}
}
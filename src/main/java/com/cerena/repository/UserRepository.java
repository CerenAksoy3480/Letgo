package com.cerena.repository;

import com.cerena.entity.User;

public class UserRepository extends RepositoryManager<User, Long> {
	public UserRepository(Class<User> entityClass) {
		super(entityClass);
	}
}
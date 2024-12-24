package com.cerena.repository;

import com.cerena.entity.User;

public class UserRepository extends RepositoryManager<User, Long> {
	public UserRepository() {
		super(User.class);
	}
}
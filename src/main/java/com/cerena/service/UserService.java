package com.cerena.service;

import com.cerena.entity.User;
import com.cerena.repository.RepositoryManager;
import com.cerena.repository.UserRepository;

public class UserService extends ServiceManager<User, Long> {
	private final UserRepository userRepository;
	
	public UserService(RepositoryManager<User, Long> repository, UserRepository userRepository, Object o) {
		super(repository);
		this.userRepository = userRepository;
	}
	

	
public boolean register(String email, String username, String password) {
	if (userRepository.findByEmail(email).isPresent()) {
		System.out.println("Email zaten kullanılıyor");
		return false;
	}
	if (userRepository.findByUsername(username).isPresent()) {
		System.out.println("Kullanıcı adı zaten kullanılıyor");
		return false;
	}
	
	User user = User.builder().username(username).password(password).email(email).build();
	save(user);
	System.out.println("Kayit basarili");
	return true;
	
	
	
	
}
	
}
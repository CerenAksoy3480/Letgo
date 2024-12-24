package com.cerena;

import com.cerena.entity.User;
import com.cerena.enums.UserStatus;
import com.cerena.repository.RepositoryManager;
import com.cerena.utility.JPAUtility;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {
	public static void main(String[] args) {
		
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Logger.getLogger("org.hibernate.SQL").setLevel(Level.OFF);
		
		JPAUtility.getEntityManager();
		
		User user = new User();
		user.setUsername("ceren");
		user.setPassword("123");
		user.setEmail("ca@gmail.com");
		user.setTel("123");
		user.setProfilImageUrl("www");
		user.setKonum("istanbul");
		user.setStatus(UserStatus.ACTIVE);
		
		RepositoryManager<User, Long> userRepo = new RepositoryManager<>(User.class);
		userRepo.save(user);
		
		
		
	
	
	}
}
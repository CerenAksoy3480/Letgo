package com.cerena;
import com.cerena.entity.User;
import com.cerena.enums.UserStatus;
import com.cerena.repository.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.cerena.entity.User.*;

public class Runner {
	public static void main(String[] args) {
		
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Logger.getLogger("org.hibernate.SQL").setLevel(Level.OFF);
		
		UserRepository userRepository = new UserRepository();
		MessageRepository messageRepository = new MessageRepository();
		IlanRepository ilanRepository = new IlanRepository();
		FavouriteIlanRepository favouriteIlan = new FavouriteIlanRepository();
		ImageRepository imageRepository = new ImageRepository();
		CategoryRepository categoryRepository = new CategoryRepository();
		
		User user1 = builder()
				.username("ahmet")
				.password("1234")
				.email("ahmet@com")
				.tel("123456789")
				.profilImageUrl("ahmet.jpg")
				.status(UserStatus.ACTIVE)
				.build();
		
		
		
		
	
	}
}
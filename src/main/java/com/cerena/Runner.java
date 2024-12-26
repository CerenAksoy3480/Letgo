package com.cerena;
import com.cerena.controller.*;
import com.cerena.entity.*;
import com.cerena.enums.MessageStatus;
import com.cerena.enums.UserStatus;
import com.cerena.repository.*;
import com.cerena.service.*;

import java.math.BigDecimal;
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
		
		
		UserController userController = new UserController();
		MainController mainController = new MainController(userController, null, null, null, null, null, null, null, null, null, null, null);
		
		User user1 = builder()
				.username("ahmet")
				.password("1234")
				.email("ahmet@com")
				.tel("123456789")
				.profilImageUrl("ahmet.jpg")
				.status(UserStatus.ACTIVE)
				.build();
		Message message1 = Message.builder().text("merhaba").status(MessageStatus.READ).build();
		Category category1 = Category.builder().name("Araç").build();
		Ilan ilan1 = Ilan.builder().title("arabaİlanı").description("araba").price(new BigDecimal(1000)).konum("ankara").build();
		FavouriteIlan alan1 = FavouriteIlan.builder().user(user1).ilan(ilan1).build();
		
		userRepository.save(user1);
		messageRepository.save(message1);
		categoryRepository.save(category1);
		ilanRepository.save(ilan1);
		favouriteIlan.save(alan1);
		
		boolean delete = userRepository.deleteById(1L);
		System.out.println(delete);
		

		mainController.mainMenu();


	
	}
}
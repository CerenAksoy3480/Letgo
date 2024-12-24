package com.cerena;

import com.cerena.entity.FavouriteIlan;
import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import com.cerena.enums.UserStatus;
import com.cerena.repository.*;
import com.cerena.utility.JPAUtility;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Runner {
	public static void main(String[] args) {
		
		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		Logger.getLogger("org.hibernate.SQL").setLevel(Level.OFF);
		
		UserRepository userRepository = new UserRepository();
		MessageRepository messageRepository = new MessageRepository();
		IlanRepository ilanRepository = new IlanRepository();
		FavouriteIlanRepository favouriteIlan = new FavouriteIlanRepository();
		
		
		
		
		
		
		
	}
}
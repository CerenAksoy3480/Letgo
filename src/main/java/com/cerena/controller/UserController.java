package com.cerena.controller;

import com.cerena.constant.ConsoleColors;
import com.cerena.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
	
	Scanner input = new Scanner(System.in);
	List<User>users = new ArrayList<User>();
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		return email.matches(emailRegex);
	}
	public void register() {
		while (true) {
			System.out.println(ConsoleColors.WHITE + "Email: ");
			String email = input.next();
			
			if (!isValidEmail(email)) {
				System.out.println(ConsoleColors.COLOR_RED + "Invalid email format. Please try again.");
				continue;
			}
			
			boolean emailExists = users.stream().anyMatch(user -> user.getEmail().equals(email));
			if (emailExists) {
				System.out.println(ConsoleColors.COLOR_RED + "Email already exists. Please choose another one.");
				continue;
			}
			
			System.out.println(ConsoleColors.WHITE + "Username: ");
			String username = input.next();
			
			boolean usernameExists = users.stream().anyMatch(user -> user.getUsername().equals(username));
			if (usernameExists) {
				System.out.println(ConsoleColors.COLOR_RED + "Username already exists. Please choose another one.");
				continue;
			}
			
			System.out.println(ConsoleColors.WHITE + "Password: ");
			String password = input.next();
			
			
			User user = new User();
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			users.add(user);
			System.out.println(ConsoleColors.COLOR_GREEN + "Registration successful!");
			break;
		}
	}
	
	public boolean login() {
		System.out.println("============Login============");
		System.out.println("Kullanıcı Adı: ");
		String username = input.next();
		
		
		System.out.println("Şifre: ");
		String password = input.next();
		
		
		boolean success =
				users.stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
		if (success) {
			System.out.println(ConsoleColors.COLOR_GREEN + "Giriş başarılı!");
			new MainController().showQueriesMenu();
		} else {
			System.out.println(ConsoleColors.COLOR_RED + "Kullanıcı adı veya şifre yanlış!");
		}
		
		
		return success;
	}
	
	
}
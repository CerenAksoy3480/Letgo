package com.cerena.controller;

import com.cerena.constant.ConsoleColors;
import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import com.cerena.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.cerena.controller.BaseController.*;


public class UserController {
	
	private final UserService userService;
	private final IlanService ilanService;
	private final MessageService messageService;
	private final ImageService imageService;
	private final FavouriteIlanService favouriteIlanService;
	private final CategoryService categoryService;
	
	
	static Scanner scanner = new Scanner(System.in);
	
	Scanner input = new Scanner(System.in);
	List<User> users = new ArrayList<User>();
	
	public UserController(UserService userService, IlanService ilanService, MessageService messageService,
	                      ImageService imageService, FavouriteIlanService favouriteIlanService,
	                      CategoryService categoryService) {
		this.userService = userService;
		this.ilanService = ilanService;
		this.messageService = messageService;
		this.imageService = imageService;
		this.favouriteIlanService = favouriteIlanService;
		this.categoryService = categoryService;
		
	}
	
	
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
		
		
		boolean success = users.stream().anyMatch(user -> user.getUsername().equals(username) && user.getPassword()
		                                                                                             .equals(password));
		if (success) {
			System.out.println(ConsoleColors.COLOR_GREEN + "Giriş başarılı!");
			showQueriesMenu();
		}
		else {
			System.out.println(ConsoleColors.COLOR_RED + "Kullanıcı adı veya şifre yanlış!");
		}
		
		
		return success;
	}
	
	private void showQueriesMenu() {
		while (true) {
			printTitle("Welcome TO THE MENU");
			System.out.println("""
					                   1.Ilanlari Listele
					                   2.Ilan Olustur
					                   3.Ilan ara
					                   4.Favori Ilanlarim
					                   5.Ilanlarim
					                   6.Mesajlarim
					                   7.Profilim
					                   8.Cikis Yap
					                   
					                   
					                   """);
			
			int choice = readInt("Enter your choice: ");
			switch (choice) {
				case 1:
					System.out.println("Ilanlari Listele");
					ilanService.findAll().forEach(System.out::println);
					break;
				case 2:
					System.out.println("Ilan Olustur");
					ilanService.save(new Ilan());
					break;
				case 3:
					System.out.println("Ilan Ara");
					ilanService.findByCategory(scanner.nextLong());
					ilanService.findByLocation(scanner.nextLong());
					ilanService.findByDateRage(scanner.nextLine(), scanner.nextLine());
					ilanService.findByUserId(scanner.nextLong());
					break;
				case 4:
					System.out.println("Favori Ilanlarim");
					favouriteIlanService.findByUserId(scanner.nextLong()).forEach(System.out::println);
					break;
				case 5:
					System.out.println("Ilanlarim");
					Long userId = scanner.nextLong();
					Optional<User> optionalUser = userService.findById(userId);
					if (optionalUser.isPresent()) {
						User user = optionalUser.get();
						if (user.getIlanlar() != null && !user.getIlanlar().isEmpty()) {
							user.getIlanlar().forEach(System.out::println);
						}
						else {
							System.out.println("Bu kullanıcının hiç ilanı yok.");
						}
					}
					else {
						System.out.println("Kullanıcı bulunamadı.");
					}
					break;
				case 6:
					System.out.println("Mesajlarim");
					messageService.findByUserId(scanner.nextLong()).forEach(System.out::println);
					break;
				case 7:
					System.out.println("Profilim");
					Long userId2 = scanner.nextLong();
					Optional<User> optionalUser2 = userService.findById(userId2);
					if (optionalUser2.isPresent()) {
						User user2 = optionalUser2.get();
						System.out.println(user2);
					}
					break;
				case 8:
					System.out.println("Cikis yapiliyor...");
					MainController.mainMenu();
					break;
				
				default:
					printErrorMessage("Invalid Choice, Please Enter Your Choice 0-21");
				
				
			}
		}
	}
}
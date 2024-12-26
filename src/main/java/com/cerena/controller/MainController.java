package com.cerena.controller;

import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import com.cerena.repository.*;
import com.cerena.service.*;
import org.hibernate.type.ComponentType;

import java.util.Optional;
import java.util.Scanner;

public class MainController extends BaseController {
	private final UserController userController;
	private final IlanController ilanController;
	private final MessageController messageController;
	private final ImageController imageController;
	private final FavouriteIlanController favouriteIlanController;
	private final CategoryController categoryController;
	private final UserService userService ;
	private final IlanService ilanService;
	private final MessageService messageService;
	private final ImageService imageService;
	private final FavouriteIlanService favouriteIlanService;
	private final CategoryService categoryService;
	
	static Scanner scanner = new Scanner(System.in);
	
	public MainController(UserController userController, IlanController ilanController, MessageController messageController, ImageController imageController, FavouriteIlanController favouriteIlanController, CategoryController categoryController, UserService userService, IlanService ilanService, MessageService messageService, ImageService imageService, FavouriteIlanService favouriteIlanService, CategoryService categoryService) {
		this.userController = new UserController();
		this.ilanController = new IlanController();
		this.messageController = new MessageController();
		this.imageController = new ImageController();
		this.favouriteIlanController = new FavouriteIlanController();
		this.categoryController = new CategoryController();
		this.userService = userService;
		this.ilanService = ilanService;
		this.messageService = messageService;
		this.imageService = imageService;
		this.favouriteIlanService = favouriteIlanService;
		this.categoryService = categoryService;
	}
	
	
	public void mainMenu() {
		while (true) {
			printTitle("Welcome MAIN Menu");
			System.out.println("""
					                      === Ana Menü ===
					                      1.Register
					                      2.Login
					                      3.Logout
					                   """);
			
			int choice = readInt("Enter your choice: ");
			switch (choice) {
				case 1:
					userController.register();
					break;
				case 2:
					userController.login();
					showQueriesMenu();
					break;
				case 3:
					System.out.println("Çıkış yapılıyor...");
					close();
					return;
				default:
					printErrorMessage("Invalid Choice, Please Enter Your Choice 1-3");
			}
		}
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
						} else {
							System.out.println("Bu kullanıcının hiç ilanı yok.");
						}
					} else {
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
					System.out.println( "Cikis yapiliyor...");
					mainMenu();
					break;
					
				default:
					printErrorMessage("Invalid Choice, Please Enter Your Choice 0-21");
				
				
			}
		}
	}





}
package com.cerena.controller;

import com.cerena.entity.Ilan;
import com.cerena.entity.User;
import com.cerena.repository.*;
import com.cerena.service.*;
import org.hibernate.type.ComponentType;

import java.util.Optional;
import java.util.Scanner;

public class MainController extends BaseController {
	private static final UserController userController=new UserController();
	private static final IlanController ilanController=new IlanController();
	private static final MessageController messageController=new MessageController();
	private static final ImageController imageController=new ImageController();
	private static final FavouriteIlanController favouriteIlanController=new FavouriteIlanController();
	private static final CategoryController categoryController=new CategoryController();
	private static UserService userService ;
	private static IlanService ilanService;
	private static MessageService messageService;
	private static ImageService imageService;
	private static FavouriteIlanService favouriteIlanService;
	private static CategoryService categoryService;
	
	static Scanner scanner = new Scanner(System.in);
	
	
	
	public static void mainMenu() {
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
	
public static void close(){
		if (scanner != null) {
			scanner.close();
		}
	}
	
}
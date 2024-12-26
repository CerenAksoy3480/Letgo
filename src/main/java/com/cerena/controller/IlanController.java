package com.cerena.controller;

import com.cerena.entity.Ilan;
import com.cerena.service.IlanService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IlanController {
	
	private static IlanService ilanService ;
	Scanner scanner = new Scanner(System.in);
	
	
	
	public void search() {
		System.out.println("1.Kategoriye gore ara");
		System.out.println("2.Konuma gore ara");
		System.out.println("3.Tarih araligina gore ara");
		System.out.println("4.Kullanici ilanlarini listele");
		int choice = Integer.parseInt(scanner.nextLine());
		switch (choice) {
			case 1:
				searchByCategory();
				break;
			case 2:
				searchByLocation();
				break;
			case 3:
//				searchByDateRage();
				break;
			case 4:
				searchByUser();
				break;
			default:
				System.out.println("Gecersiz secim");
	}
	
}
	

	
	private void searchByCategory() {
		System.out.println("Kategori ID'sini girin:");
		Long categoryId = scanner.nextLong();
		List<Ilan> ilanlar = ilanService.findByCategory(categoryId);
		if (ilanlar.isEmpty()) {
			System.out.println("Secilen kategoriye ait ilan bulunamadi");
		}else {
			ilanlar.forEach(System.out::println);
			
		}
	}
	
	private void searchByLocation() {
		System.out.println("Konum ID'sini girin:");
        Long location = scanner.nextLong();
        List<Ilan> ilanlar = ilanService.findByLocation(location);
        if (ilanlar.isEmpty()) {
            System.out.println("Secilen konuma ait ilan bulunamadi");
        }else {
            ilanlar.forEach(System.out::println);
            
        }
	}
	
	
	private void searchByDateRage() {
		System.out.println("Baslangic tarihi girin (YYYY-MM-DD):");
        String startDate = scanner.nextLine();
		LocalDate.parse(startDate);
        System.out.println("Bitis tarihi girin (YYYY-MM-DD):");
        String endDate = scanner.nextLine();
		LocalDate.parse(endDate);
        List<Ilan> ilanlar = ilanService.findByDateRage(startDate, endDate);
        if (ilanlar.isEmpty()) {
            System.out.println("Secilen tarih araligina ait ilan bulunamadi");
        } else {
            ilanlar.forEach(System.out::println);

        }
	}
	
	private void searchByUser() {
		System.out.println("Kullanici ID'sini girin:");
        Long userId = scanner.nextLong();
        List<Ilan> ilanlar = ilanService.findByUserId(userId);
        if (ilanlar.isEmpty()) {
            System.out.println("Kullaniciya ait ilan bulunamadi");
        }else {
            ilanlar.forEach(System.out::println);
            
        }
	}
	
	
}
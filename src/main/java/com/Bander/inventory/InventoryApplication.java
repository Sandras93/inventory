package com.Bander.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "h2");

		SpringApplication.run(InventoryApplication.class, args);
	}

}

package com.challengerFinal.arte;

import com.challengerFinal.arte.model.UserGlobal;
import com.challengerFinal.arte.repositories.UserGlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArteApplication.class, args);
	}
	@Autowired
	UserGlobalRepository userGlobalRepository;
	@Override
	public void run(String... args) throws Exception {
		UserGlobal userArtist = new UserGlobal("juan","Da vinci","juda@goto.com","juanda");
		UserGlobal userClient = new UserGlobal("Homero","Simpson","hosi@goto.com","homerin");

		userGlobalRepository.save(userArtist);
		userGlobalRepository.save(userClient);
	}
}

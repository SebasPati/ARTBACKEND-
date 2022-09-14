package com.challengerFinal.arte;

import com.challengerFinal.arte.model.Artist;
import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.service.ArtistService;
import com.challengerFinal.arte.service.ClientService;
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
	ClientService userGlobalRepository;
	@Autowired
	ArtistService artistService;
	@Override
	public void run(String... args) throws Exception {
		Client client = new Client("Juan","Da vinci","juda@goto.com","juanda","654");
		Client userClient = new Client("Homero","Simpson","hosi@goto.com","homerin","erty");

		userGlobalRepository.saveUser(client);
		userGlobalRepository.saveUser(userClient);
		System.out.println(client);
		Artist artist = new Artist("Jhon","Jhonas","jhojho@goto.com","Jhon bon jhons","654");
		Artist artist1 = new Artist("Bart","Simpson","bs@goto.com","el flautista","erty");

		artistService.saveUser(artist);
		artistService.saveUser(artist1);
		System.out.println(artist);
	}
}

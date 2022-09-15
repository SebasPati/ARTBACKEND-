package com.challengerFinal.arte;

import com.challengerFinal.arte.model.Artist;
import com.challengerFinal.arte.model.Artworks;
import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.service.ArtistService;
import com.challengerFinal.arte.service.ClientService;
import com.challengerFinal.arte.service.ServiceArtworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ArteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArteApplication.class, args);
	}
	@Autowired
	ClientService userGlobalRepository;
	@Autowired
	ArtistService artistService;
	@Autowired
	ServiceArtworks artworksService;

	@Override
	public void run(String... args) throws Exception {
		Client client = new Client("Juan","Da vinci","juda@goto.com","juanda","654");
		Client userClient = new Client("Homero","Simpson","hosi@goto.com","The Homo","erty");
		userGlobalRepository.saveUser(client);
		userGlobalRepository.saveUser(userClient);

		List<String> socialNetwords = List.of("Twtter","Instagram","Tick Tock");
		System.out.println(client);
		Artist artist = new Artist("Jhon","Jhonas","jhojho@goto.com","Jhon bon jhons","dggjhy",socialNetwords);
		Artist artist1 = new Artist("Bart","Simpson","bs@goto.com","The Barto","ertuyghf",socialNetwords);

		artistService.saveUser(artist);
		artistService.saveUser(artist1);
		System.out.println(artist);
		List<Double> dimensions = List.of(12.5,24.6,36.5);

		Artworks artworks1 = new Artworks("Mona lisa",345.0,"lorem Ipsum",dimensions,true,12,artist);
		artworksService.saveArtworks(artworks1);

		Artworks artworks2 = new Artworks("Mona lisa",345.0,"lorem Ipsum",dimensions,true,12,artist1);
		artworksService.saveArtworks(artworks2);
		System.out.println(artworks1);
		System.out.println(artworks2);
	}
}
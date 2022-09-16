package com.challengerFinal.arte;

import com.challengerFinal.arte.model.Artworks;
import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.model.OrderLineal;
import com.challengerFinal.arte.model.OrderRequest;
import com.challengerFinal.arte.model.enums.StatePedido;
import com.challengerFinal.arte.model.enums.TypeUser;
import com.challengerFinal.arte.service.ClientService;
import com.challengerFinal.arte.service.OrderLinealService;
import com.challengerFinal.arte.service.OrderService;
import com.challengerFinal.arte.service.ServiceArtworks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ArteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArteApplication.class, args);
		System.out.println("Welcome to ArteApplication for Rafael");
	}
	@Autowired
	ClientService userGlobalRepository;

	@Autowired
	ServiceArtworks artworksService;

	@Autowired
	OrderService orderService;
	@Autowired
	OrderLinealService orderLinealService;

	@Override
	public void run(String... args) throws Exception {
		List<String> socialNetwords = List.of("Twtter","Instagram","Tick Tock");
		Client client = new Client("Juan","Da vinci","juda@goto.com","juanda","654", TypeUser.CLIENT);
		Client artist = new Client("Homero","Simpson","Lord Simpson","hosi@goto.com","3100000","098765",TypeUser.ARTIST,"Cll siempre viva 123",socialNetwords);
		Client admin = new Client("admin_db","Simpson","db@admin.com","31000000","admin1234",TypeUser.ADMIN);
		userGlobalRepository.saveUser(client);
		userGlobalRepository.saveUser(artist);
		userGlobalRepository.saveUser(admin);
		System.out.println(client);
		System.out.println(artist);
		System.out.println(admin);

		List<Double> dimensions = List.of(12.5,24.6,36.5);

		Artworks artworks1 = new Artworks("Mona lisa",345.0,"lorem Ipsum",dimensions,true,12,artist);
		artworksService.saveArtworks(artworks1);
		Artworks artworks2 = new Artworks("Mona lisa",345.0,"lorem Ipsum",dimensions,true,12,artist);
		artworksService.saveArtworks(artworks2);
		System.out.println(artworks1);
		System.out.println(artworks2);

		OrderRequest orderRequest = new OrderRequest(LocalDate.now(), StatePedido.CONFIRMED,client);
		OrderRequest orderRequestDos = new OrderRequest(LocalDate.now(), StatePedido.CONFIRMED,client);
		orderService.saveRequest(orderRequest);
		orderService.saveRequest(orderRequestDos);
		System.out.println(orderRequest);
		System.out.println(orderRequestDos);

		OrderLineal orderLineal = new OrderLineal(4,orderRequest,artworks1);
		OrderLineal orderLinealDos = new OrderLineal(3,orderRequestDos,artworks1);
		OrderLineal orderLinealTres = new OrderLineal(2,orderRequest,artworks2);
		OrderLineal orderLinealCuster = new OrderLineal(1,orderRequestDos,artworks2);
		orderLinealService.saveOrderLineal(orderLineal);
		orderLinealService.saveOrderLineal(orderLinealDos);
		orderLinealService.saveOrderLineal(orderLinealTres);
		orderLinealService.saveOrderLineal(orderLinealCuster);
		System.out.println(orderLineal);
		System.out.println(orderLinealDos);
		System.out.println(orderLinealTres);
		System.out.println(orderLinealCuster);


	}
}
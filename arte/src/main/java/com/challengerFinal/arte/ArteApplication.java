package com.challengerFinal.arte;

import com.challengerFinal.arte.model.*;
import com.challengerFinal.arte.model.enums.StatePedido;
import com.challengerFinal.arte.model.enums.TypeUser;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.repositories.PaymentRepository;
import com.challengerFinal.arte.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ArteApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ArteApplication.class, args);
		System.out.println("Welcome to ArteApplication for Rafael");
	}
	@Autowired
	ClientRepository userGlobalRepository;

	@Autowired
	ServiceProduct artworksService;

	@Autowired
	OrderService orderService;
	@Autowired
	ShoppingCartService shoppingCartService;
	@Autowired
	GoodsReceiptService goodsReceiptService;

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		List<String> socialNetwords = List.of("Twtter","Instagram","Tick Tock");
		Client client = new Client("Juan","Da vinci","juda@goto.com",passwordEncoder.encode("654"),TypeUser.CLIENT,0,"image/jpeg");
		Client artist = new Client("Juan","Da vinci","juda@goto.com",passwordEncoder.encode("654"),TypeUser.ARTIST,0,"image/jpeg");
		Client admin = new Client("Juan","Da vinci","juda@goto.com",passwordEncoder.encode("654"),TypeUser.ADMIN,0,"image/jpeg");
		userGlobalRepository.save(client);
		userGlobalRepository.save(artist);
		userGlobalRepository.save(admin);
		System.out.println(client);
		System.out.println(artist);
		System.out.println(admin);

		List<Double> dimensions = List.of(12.5,24.6,36.5);

		Product product1 = new Product("Mona lisa","lorem Ipsum",dimensions,"category",artist);
		artworksService.saveArtworks(product1);
		Product product2 = new Product("Mona lisa","lorem Ipsum",dimensions,"category",artist);
		artworksService.saveArtworks(product2);
		System.out.println(product1);
		System.out.println(product2);


		ShoppingCart shoppingCart = new ShoppingCart(client);
		ShoppingCart shoppingCartDos = new ShoppingCart(client);
		ShoppingCart shoppingCartTres = new ShoppingCart(client);
		ShoppingCart shoppingCartCuster = new ShoppingCart(client);
		shoppingCartService.saveShoppingCard(shoppingCart);
		shoppingCartService.saveShoppingCard(shoppingCartDos);
		shoppingCartService.saveShoppingCard(shoppingCartTres);
		shoppingCartService.saveShoppingCard(shoppingCartCuster);
		System.out.println(shoppingCart);
		System.out.println(shoppingCartDos);
		System.out.println(shoppingCartTres);
		System.out.println(shoppingCartCuster);

		OrderRequest orderRequest = new OrderRequest(product1,LocalDate.now(), StatePedido.CONFIRMED,234.4,12,shoppingCart);
		OrderRequest orderRequestDos = new OrderRequest(product1,LocalDate.now(), StatePedido.CONFIRMED,25343.3,12,shoppingCart);
		orderService.saveRequest(orderRequest);
		orderService.saveRequest(orderRequestDos);
		System.out.println(orderRequest);
		System.out.println(orderRequestDos);



		List<Integer> paymentsDebitCard = List.of(1);
		List<Integer> paymentsCreditCard = List.of(1, 3, 6,12,24,36);
		List<Integer> paymentsCash = List.of(1);


		Payment payment1 = new Payment("Cash",paymentsCash);
		Payment payment2 = new Payment("Credit",paymentsCreditCard);
		Payment payment3 = new Payment("Debit",paymentsDebitCard);

		paymentRepository.save(payment1);
		paymentRepository.save(payment2);
		paymentRepository.save(payment3);

		GoodsReceipt goodsReceiptOne = new GoodsReceipt((orderRequest.getPrice()*1.010)*12,true,LocalDate.now(),12,shoppingCart,payment1);
		goodsReceiptService.saveGoodsReceipt(goodsReceiptOne);
		System.out.println(goodsReceiptOne);


	}
}
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
		Client client = new Client("Juan","Da vinci","juda1@goto.com",passwordEncoder.encode("654"),TypeUser.CLIENT,0,"image/jpeg");
		Client artist = new Client("Juan","Da vinci","juda2@goto.com",passwordEncoder.encode("654"),TypeUser.ARTIST,0,"image/jpeg");
		Client admin = new Client("Juan","Da vinci","juda3@goto.com",passwordEncoder.encode("654"),TypeUser.ADMIN,0,"image/jpeg");
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
		//CLAU:
		Client cc9 = new Client("cc9", "cc9", "cc", "cc", TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc1= new Client("cc1+p=1", "cc1l", "cc1@art.com", "cc1", TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc2= new Client("cc2+p=2", "cc2l", "cc2@art.com", "cc2", TypeUser.ARTIST, 1,  "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc3= new Client("cc3", "cc3l", "cc3@art.com", "cc3", TypeUser.ARTIST, 5 , "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc4= new Client("cc4", "cc4l", "cc4@art.com", "cc4", TypeUser.ARTIST, 1 , "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc5= new Client("cc5+5=p", "cc5l", "cc5@art.com", "cc5", TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc6= new Client("cc6", "cc6l", "cc6@art.com", "cc6", TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc7= new Client("cc7", "cc7l", "cc7@art.com", "cc7", TypeUser.ARTIST, 7, "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		Client cc8= new Client("cc8", "cc8l", "cc8@art.com", "cc8", TypeUser.ARTIST, 10, "https://media.istockphoto.com/photos/portrait-of-medieval-african-young-woman-in-black-vintage-dress-with-picture-id1325210422?k=20&m=1325210422&s=612x612&w=0&h=l6BX2_nzVxsBgroqdmAbjS2B6ITJ3MKnpGgHewULy9Q=");
		userGlobalRepository.save(cc1);
		userGlobalRepository.save(cc2);
		userGlobalRepository.save(cc3);
		userGlobalRepository.save(cc4);
		userGlobalRepository.save(cc5);
		userGlobalRepository.save(cc6);
		userGlobalRepository.save(cc7);
		userGlobalRepository.save(cc8);
		userGlobalRepository.save(cc9);
		//CLAU PRODUCTOS
		Product cp1 = new Product("cp1", "cpdescrip", List.of(30.00,10.00), "category", cc1);
		Product cp2 = new Product("cp2", "cpdescrip", List.of(30.00,10.00), "category2", cc2);
		Product cp3 = new Product("cp3", "cpdescrip", List.of(30.00,10.00), "category", cc2);
		Product cp4 = new Product("cp4", "cpdescrip", List.of(30.00,10.00), "category2", cc5);
		Product cp5 = new Product("cp5", "cpdescrip", List.of(30.00,10.00), "category", cc5);
		Product cp6 = new Product("cp6", "cpdescrip", List.of(30.00,10.00), "category3", cc5);
		Product cp7 = new Product("cp7", "cpdescrip", List.of(30.00,10.00), "category3", cc5);
		Product cp8 = new Product("cp8", "cpdescrip", List.of(30.00,10.00), "category3", cc5);
		artworksService.saveArtworks(cp1);
		artworksService.saveArtworks(cp2);
		artworksService.saveArtworks(cp3);
		artworksService.saveArtworks(cp4);
		artworksService.saveArtworks(cp5);
		artworksService.saveArtworks(cp6);
		artworksService.saveArtworks(cp7);
		artworksService.saveArtworks(cp8);


	}
}
package com.challengerFinal.arte;

import com.challengerFinal.arte.model.*;
import com.challengerFinal.arte.model.enums.StatePedido;
import com.challengerFinal.arte.model.enums.TypeUser;
import com.challengerFinal.arte.repositories.ClientRepository;
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
	OrderLinealService orderLinealService;
	@Autowired
	GoodsReceiptService goodsReceiptService;

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

		OrderRequest orderRequest = new OrderRequest(LocalDate.now(), StatePedido.CONFIRMED,client);
		OrderRequest orderRequestDos = new OrderRequest(LocalDate.now(), StatePedido.CONFIRMED,client);
		orderService.saveRequest(orderRequest);
		orderService.saveRequest(orderRequestDos);
		System.out.println(orderRequest);
		System.out.println(orderRequestDos);

		OrderLineal orderLineal = new OrderLineal(4,orderRequest, product1);
		OrderLineal orderLinealDos = new OrderLineal(3,orderRequestDos, product1);
		OrderLineal orderLinealTres = new OrderLineal(2,orderRequest, product2);
		OrderLineal orderLinealCuster = new OrderLineal(1,orderRequestDos, product2);
		orderLinealService.saveOrderLineal(orderLineal);
		orderLinealService.saveOrderLineal(orderLinealDos);
		orderLinealService.saveOrderLineal(orderLinealTres);
		orderLinealService.saveOrderLineal(orderLinealCuster);
		System.out.println(orderLineal);
		System.out.println(orderLinealDos);
		System.out.println(orderLinealTres);
		System.out.println(orderLinealCuster);

		GoodsReceipt goodsReceiptOne = new GoodsReceipt(product1,2345.45,true,LocalDate.now(),2);
		GoodsReceipt goodsReceiptTwo = new GoodsReceipt(product1,2845.45,true,LocalDate.now(),10);
		GoodsReceipt goodsReceiptTree = new GoodsReceipt(product2,78729.45,true,LocalDate.now(),10);
		GoodsReceipt goodsReceiptFour = new GoodsReceipt(product2,1345.45,true,LocalDate.now(),40);
		GoodsReceipt goodsReceiptFive = new GoodsReceipt(product1,9345.45,true,LocalDate.now(),5);
		goodsReceiptService.saveGoodsReceipt(goodsReceiptOne);
		goodsReceiptService.saveGoodsReceipt(goodsReceiptTwo);
		goodsReceiptService.saveGoodsReceipt(goodsReceiptTree);
		goodsReceiptService.saveGoodsReceipt(goodsReceiptFour);
		goodsReceiptService.saveGoodsReceipt(goodsReceiptFive);
		System.out.println(goodsReceiptOne);
		System.out.println(goodsReceiptTwo);
		System.out.println(goodsReceiptTree);
		System.out.println(goodsReceiptFour);
		System.out.println(goodsReceiptFive);

	}
}
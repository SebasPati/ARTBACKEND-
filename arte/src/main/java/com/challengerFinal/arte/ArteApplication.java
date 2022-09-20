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

		Client artist = new Client("Juan","Da vinci","don Bot","juda2@goto.com","3124523424",passwordEncoder.encode("654"),TypeUser.ARTIST,"cerca de la casa",0,"image/jpeg",socialNetwords);
		Client admin = new Client("Juan","Da vinci","juda3@goto.com",passwordEncoder.encode("654"),TypeUser.ADMIN,0,"image/jpeg");


		userGlobalRepository.save(client);
		userGlobalRepository.save(artist);
		userGlobalRepository.save(admin);
		System.out.println(client);
		System.out.println(artist);
		System.out.println(admin);

		List<Double> dimensions = List.of(12.5,24.6,36.5);
		String image = "image/jpeg";

			Product product1 = new Product("Mona lisa","lorem Ipsum","categoría",232.2,true,LocalDate.now(),12,dimensions,image,artist);
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
		//CLAU:
		Client artist1 = new Client("Rosalia", "Ferrando", "roasliaferrando@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/selfemployed-painter-looking-at-the-camera-cheerfully-picture-id1364209752?k=20&m=1364209752&s=612x612&w=0&h=yH-XL4ga0E7ixxn-KHexzIC5wWoBdTAX-q6NsHLOOcA=");
		Client artist2= new Client("Francisco José", "Manzanares", "franciscojose@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/portrait-of-young-dark-haired-concentrated-caucasian-white-male-with-picture-id1333064056?k=20&m=1333064056&s=612x612&w=0&h=WIBoskVGacXKcFocqymTxwzntfZx2PieiJR3Zptes8w=");
		Client artist3= new Client("María Lucía", "Encinas", "marialucia@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 1,  "https://media.istockphoto.com/photos/smiling-young-woman-female-artist-in-apron-looking-at-camera-standing-picture-id1327671241?k=20&m=1327671241&s=612x612&w=0&h=xDAfS2QuFeGQG_F9d671q03TLXhNtKoDR962VETfOao=");
		Client artist4= new Client("Triana", "Ribes", "trianaribes@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 5 , "https://media.istockphoto.com/photos/beautiful-afro-woman-with-pigtails-and-stylish-clothes-picture-id1342849839?k=20&m=1342849839&s=612x612&w=0&h=kzIoHr71R1RG4oTrCUc6FqNkf8fF6_Tx1KlWJGAFV1c=");
		Client artist5= new Client("Avelino", "Torre", "avelinotorre@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 1 , "https://media.istockphoto.com/photos/working-on-creative-ideas-at-night-picture-id1356061017?k=20&m=1356061017&s=612x612&w=0&h=PoVD5yO_5fpPMxsvTkXeS83LLykkzecO2NKFh1OSsVU=");
		Client artist6= new Client("Adelina", "Barroso", "adelinabarroso@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/ceramic-workshop-picture-id1126452727?k=20&m=1126452727&s=612x612&w=0&h=puqfmxVU_61aohW5XxB05kUYI_p1gP8bkw01nanlW9g=");
		Client artist7= new Client("Mar", "Beltran", "marbeltran@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 1, "https://media.istockphoto.com/photos/young-professional-female-singer-recording-a-new-song-album-inside-picture-id1319579584?k=20&m=1319579584&s=612x612&w=0&h=wEVsZ-9SXhRX7SFgnvSgx1t7DfzuwRzHLhaTKZYKWxw=");
		Client artist8= new Client("Mariano", "Mayor", "marianomayor@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 7, "https://media.istockphoto.com/photos/talented-male-artist-energetically-and-violently-using-paint-brush-he-picture-id1183183769?k=20&m=1183183769&s=612x612&w=0&h=2XU8_xIH02_6sfTQjusOoJGbBN-_hkC8WU4HSrrrblU=");
		Client artist9= new Client("Julio", "Romo", "julioromo@art.com", passwordEncoder.encode("00"), TypeUser.ARTIST, 10, "https://media.istockphoto.com/photos/young-african-musician-smiling-at-camera-picture-id1200779750?k=20&m=1200779750&s=612x612&w=0&h=lE3pHr2wAotZ3n02myTdy0UKMrcw8ar_q8aZR0ohVE8=");
		userGlobalRepository.save(artist1);
		userGlobalRepository.save(artist2);
		userGlobalRepository.save(artist3);
		userGlobalRepository.save(artist4);
		userGlobalRepository.save(artist5);
		userGlobalRepository.save(artist6);
		userGlobalRepository.save(artist7);
		userGlobalRepository.save(artist8);
		userGlobalRepository.save(artist9);



		//CLAU PRODUCTOS
		Product art1= new Product("Angel in Fesccoes", "A painting of angels in heaven made by one of the most renowned artists up to that time. The texture of us canvas creates an unforgettable experience", "paint", 200000.00, true, LocalDate.now(), 2, List.of(20.00, 40.00), "https://media.istockphoto.com/photos/angel-in-frescoes-in-the-dome-of-brunelleschi-picture-id502278435?k=20&m=502278435&s=612x612&w=0&h=JZTuiLZ5RKPS5eZbK8f6IHxTTBVB-d4OMsFbYPuXsxU=", artist1);
		Product art2= new Product("Adam Picture", "The Creation of Adam is a fresco on the vault of the Sistine Chapel, painted by Michael... the Tuscan artist, in which God gives life to Adam, the first man.", "paint", 56000.00, true, LocalDate.now(), 6, List.of(20.00, 40.00), "https://media.istockphoto.com/photos/adam-picture-id92879541?k=20&m=92879541&s=612x612&w=0&h=Q-Lfu2NI1dwrROrmXkYzke66tVTaWrwMbHBEgJZeJVg=", artist1);
		Product art3= new Product("Ergo Paint", "Digital painting using different types of brushes representing different textures, vibrant colors and strangely harmonic expression", "digital art", 270000.00, true, LocalDate.now(), 1, List.of(), "https://media.istockphoto.com/photos/modern-conceptual-artwork-with-ancient-statue-contemporary-art-picture-id1316447596?k=20&m=1316447596&s=612x612&w=0&h=YQ2SyTk8S8x7ezsdgzpNoWvrRSLZy0V7-q1pO11A20o=", artist2);
		Product art4= new Product("Dante and the divine comedy", "The Divine Comedy, also known simply as Comedy, is a poem written by Dante Alighieri. and this is the illustration", "paint", 800.00, true, LocalDate.now(), 15, List.of(200.00, 100.00), "https://media.istockphoto.com/photos/dante-and-the-divine-comedy-in-duomo-picture-id152941916?k=20&m=152941916&s=612x612&w=0&h=C9jNvVjYgKegrMegZO2a7DJP5ibcfF_iH5hzk3PsPH8=", artist1);
		Product art12= new Product("Seville the fresco resurrected", "Representation of the resurrection of Jesus starring him and other characters in the clouds of heaven.", "paint", 7900.00, true, LocalDate.now(), 13, List.of(80.00, 80.00), "https://media.istockphoto.com/illustrations/seville-the-fresco-resurrected-christ-in-venerables-sacerdotes-illustration-id471617800?k=20&m=471617800&s=612x612&w=0&h=yf4aZ8cbw9oHGHqTNR_Sb57gZo41yHajGfPoHJVGAdU=", artist1);
		Product art11= new Product("Bergamo Coronation", "The coronation of Bergamo in the sky.The texture of us canvas creates an unforgettable experience", "paint", 89600.00, true, LocalDate.now(), 4, List.of(60.00, 120.00), "https://media.istockphoto.com/illustrations/bergamo-coronation-of-hl-mary-in-church-san-alessandro-illustration-id177767071?k=20&m=177767071&s=612x612&w=0&h=_jWlAucQjXKE_IWV1FGx9uJaz4LoAGiLIcZebjlx4aU=", artist1);
		Product art7= new Product("Ansient Sculpture", "Ancient sculpture of the rape of the sabine women florence italy picture", "sculpture", 900050.00, true, LocalDate.now(), 1, List.of(150.00, 60.00), "https://media.istockphoto.com/photos/ancient-sculpture-of-the-rape-of-the-sabine-women-florence-italy-picture-id694142262?k=20&m=694142262&s=612x612&w=0&h=SPLIz8PjdNZfb1hGLXeovap7k1acgMjj5_Meb6SOpZI=", artist2);
		Product art8= new Product("Five Flowers", "Bouquet of five flowers of blossoming dandelions of unusual colorful picture", "digital art", 6000.00, true, LocalDate.now(), 4, List.of(), "https://media.istockphoto.com/photos/bouquet-of-five-flowers-of-blossoming-dandelions-of-unusual-colorful-picture-id1223668190?k=20&m=1223668190&s=612x612&w=0&h=JQjlgR0c0rd5VTfk41I2Gr6MiSyj2uuq-8PJ_Uf-OTs=", artist2);
		Product art9= new Product("Beautiful Angel", "The angel of the fallen sunsets, representing the sadness for the death of the protagonist's family, in detail you can see even the tears arising", "sculpture", 4000.00, true, LocalDate.now(), 2, List.of(200.00, 40.00), "https://media.istockphoto.com/photos/beautiful-angel-picture-id155279861?k=20&m=155279861&s=612x612&w=0&h=DHgm3XLQjz5aEa6F_MkWTxGSqyG8ycNV4qjWctSysks=", artist2);
		Product art10= new Product("Robotic Coronation", "Metal sculpture, a robot with a crown of polished spikes. Created 3000 years ago and cared for until then by the descendants of the creator.", "sculpture", 630.00, true, LocalDate.now(), 3, List.of(70.00, 80.00), "https://i.pinimg.com/originals/a9/90/5e/a9905eded97106bd2300dd873a213f48.jpg", artist2);
		Product art6= new Product("Michelangelo Spirit", "Marble sculpture by Michelangelo David. Exported from the United States.", "sculpture", 8000.00, true, LocalDate.now(), 3, List.of(300.00, 40.00), "https://i.pinimg.com/originals/f8/49/bf/f849bfd7cc2da33e949a1f5cd9db71a6.png", artist2);
		Product art5= new Product("Venus", "Imagine Lion Studio Venus resin statue in stock gold version collection", "sculpture", 6000000.00, true, LocalDate.now(), 1, List.of(40.00, 40.00), "https://i.pinimg.com/736x/a8/36/fd/a836fdf1ba811157586054afffff3074.jpg", artist2);
		Product art13= new Product("Venus", "Modern conceptual art poster with ancient statue of bust of venus of  picture", "digital art", 46000.00, true, LocalDate.now(), 9, List.of(), "https://media.istockphoto.com/photos/modern-conceptual-art-poster-with-ancient-statue-of-bust-of-venus-of-picture-id1171968802?k=20&m=1171968802&s=612x612&w=0&h=rvkR9L4wT6wxkO705Rpw01lidI60BaaU8x_M8y1wgyQ=", artist1);
		artworksService.saveArtworks(art1);
		artworksService.saveArtworks(art2);
		artworksService.saveArtworks(art3);
		artworksService.saveArtworks(art4);
		artworksService.saveArtworks(art5);
		artworksService.saveArtworks(art6);
		artworksService.saveArtworks(art7);
		artworksService.saveArtworks(art8);
		artworksService.saveArtworks(art9);
		artworksService.saveArtworks(art10);
		artworksService.saveArtworks(art11);
		artworksService.saveArtworks(art12);
		artworksService.saveArtworks(art13);

	}
}
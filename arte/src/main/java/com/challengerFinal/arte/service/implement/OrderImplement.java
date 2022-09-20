package com.challengerFinal.arte.service.implement;

import com.challengerFinal.arte.dtos.OrderRequestDto;
import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.model.OrderRequest;
import com.challengerFinal.arte.model.Product;
import com.challengerFinal.arte.model.ShoppingCart;
import com.challengerFinal.arte.model.enums.StatePedido;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.repositories.OrderRepository;
import com.challengerFinal.arte.repositories.ProductRepository;
import com.challengerFinal.arte.repositories.ShoppingCartRepository;
import com.challengerFinal.arte.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderImplement implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Override
    public OrderRequestDto getOrderRequest(Long id) {
        return orderRepository.findById(id).map(OrderRequestDto::new).orElse(null);
    }

    @Override
    public List<OrderRequestDto> getOrderRequestsAll() {
        return orderRepository.findAll().stream().map(OrderRequestDto::new).collect(Collectors.toList());
    }

    @Override
    public OrderRequest saveRequest(OrderRequest orderRequest) {
        return orderRepository.save(orderRequest);
    }

    @Override
    public ResponseEntity<Object> createPurchaseOrder(String nameProduct, int cant, Authentication authentication) {
        Client clientConected = clientRepository.findByEmail(authentication.getName());
        Product requestedProduct = productRepository.findByName(nameProduct);
        ShoppingCart shoppingCart = shoppingCartRepository.findByClientAndActive(clientConected,true);
        //ShoppingCart shoppingCart = new ShoppingCart(clientConected);

        if (shoppingCart == null) {
            return new ResponseEntity<>("Esribir aquí una nota"+shoppingCart,HttpStatus.FORBIDDEN);
        }
        if (nameProduct.isEmpty() || cant==0) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (requestedProduct ==  null) {
            return new ResponseEntity<>("We do not sell this product", HttpStatus.FORBIDDEN);
        }

        if (requestedProduct.getUnits() <  cant) {
            return new ResponseEntity<>("There is not enough stock for this order", HttpStatus.FORBIDDEN);
        }
        //Creamos la order de pedido del product.
        OrderRequest orderRequest = new OrderRequest(
                requestedProduct,
                LocalDate.now(),
                StatePedido.CONFIRMED,
                ((requestedProduct.getPrice()*1.010) * cant),
                cant,shoppingCart);
        orderRepository.save(orderRequest);

        int currentUnits = requestedProduct.getUnits()  - cant;
        requestedProduct.setUnits(currentUnits);
        productRepository.save(requestedProduct);

        return new ResponseEntity<>(
                "Request created",
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> deleteItem(Long id) {
        OrderRequest toitemDelete = orderRepository.findById(id).orElse(null);
        if (toitemDelete == null) {

            return new ResponseEntity<>(
                    "El item no está en el carrito",
                    HttpStatus.FORBIDDEN);
        }

        orderRepository.deleteById(toitemDelete.getId());

        return new ResponseEntity<>("Item removed from cart", HttpStatus.OK);
    }

}

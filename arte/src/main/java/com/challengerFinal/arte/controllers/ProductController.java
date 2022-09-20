package com.challengerFinal.arte.controllers;

import com.challengerFinal.arte.dtos.CreateProductDto;
import com.challengerFinal.arte.dtos.ProductDto;
import com.challengerFinal.arte.dtos.UpdateProductDTO;
import com.challengerFinal.arte.repositories.ClientRepository;
import com.challengerFinal.arte.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
    @Autowired
    ServiceProduct productService;
    @Autowired
    ClientRepository clientRepository;

    @GetMapping(value = "/products")
    public List<ProductDto> getArtworks() {
        return productService.getArtworksAll();
    }
    @GetMapping(value = "/products/{id}")
    public ProductDto getArtworksId(@PathVariable Long id) {
        return productService.getArtworkById(id);
    }

    @PostMapping("/clients/current/products")
    public ResponseEntity<Object> createProduct(
            Authentication authentication,
            @RequestBody CreateProductDto createProductDto) {
        return productService.createProduct(authentication,createProductDto);
    }

    @PutMapping("/products/update/{id}")
    //si son metodos diferentes puedo ponerle la misma ruta
    //Lo pongo para identificar a que parametro se refiere si tengo mas de uno en la ruta, ej /{nombre}
    public ResponseEntity<Object> updateProduct(
            @PathVariable("id")Long id,@RequestBody UpdateProductDTO updateProductDTO) {
        return productService.updateProduct(id,updateProductDTO);
        //PathVariable se usa para los id

    }

    @PatchMapping("/clients/current/products/update/{id}")
    public ResponseEntity<Object> patchProduct(
            @RequestBody UpdateProductDTO updateProductDTO,
            @PathVariable ("id") Long id){
        return productService.patchProduct(id, updateProductDTO);
        //con requestBody mandamos un objeto, va a usar un solo dato
        // y va a construir un objeto con un solo dato, por ende necesita un contructor para cada atributo
    }

    @DeleteMapping("products/delete/{id}")
    public ResponseEntity<Object> deleteProduct(
            @PathVariable("id")Long id){
        return productService.deleteProduct(id);
    }

}

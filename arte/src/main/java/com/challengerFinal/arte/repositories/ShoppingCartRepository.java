package com.challengerFinal.arte.repositories;

import com.challengerFinal.arte.model.Client;
import com.challengerFinal.arte.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    //ShoppingCart findByClientAndIsActive(Client client, Boolean isActive);
}
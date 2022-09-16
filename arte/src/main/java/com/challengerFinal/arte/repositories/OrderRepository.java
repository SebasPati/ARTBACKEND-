package com.challengerFinal.arte.repositories;

import com.challengerFinal.arte.model.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<OrderRequest, Long> {
}
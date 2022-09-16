package com.challengerFinal.arte.repositories;

import com.challengerFinal.arte.model.OrderLineal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderLinealRepository extends JpaRepository<OrderLineal, Long> {
}
package com.challengerFinal.arte.repositories;

import com.challengerFinal.arte.model.OrderRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderRequest, Long> {
}
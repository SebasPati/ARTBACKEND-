package com.challengerFinal.arte.repositories;

import com.challengerFinal.arte.model.UserGlobal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserGlobalRepository extends JpaRepository<UserGlobal, Long> {

}
package com.larbotech.archunit.classic.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.larbotech.archunit.classic.model.Client;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
	
}

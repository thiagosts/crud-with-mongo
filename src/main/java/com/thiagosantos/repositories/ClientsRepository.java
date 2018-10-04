package com.thiagosantos.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thiagosantos.documents.Clients;

public interface ClientsRepository extends MongoRepository<Clients, String> {
	

}

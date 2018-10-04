package com.thiagosantos.services;

import java.util.List;

import com.thiagosantos.documents.Clients;

public interface ClientsService {
	
	List<Clients> findAllClients();
	
	Clients findByIdClients(String id);
	
	Clients createClients(Clients clients);
	
	Clients updateClients(Clients clients);
	
	void deleteClients(String id);
	

}

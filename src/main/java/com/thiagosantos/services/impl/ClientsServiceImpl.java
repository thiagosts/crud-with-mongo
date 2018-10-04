 package com.thiagosantos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagosantos.documents.Clients;
import com.thiagosantos.repositories.ClientsRepository;
import com.thiagosantos.services.ClientsService;

@Service	
public class ClientsServiceImpl implements ClientsService {

	@Autowired
	ClientsRepository clientrepository;
	
	@Override
	public List<Clients> findAllClients() {
		// TODO Auto-generated method stub
		return this.clientrepository.findAll() ;
	}

	@Override
	public Clients findByIdClients(String id) {
		// TODO Auto-generated method stub
		return this.clientrepository.findOne(id);
	}

	@Override
	public Clients createClients(Clients clients) {
		// TODO Auto-generated method stub
		return this.clientrepository.save(clients);
	}

	@Override
	public Clients updateClients(Clients clients) {
		// TODO Auto-generated method stub
		return this.clientrepository.save(clients);
	}

	@Override
	public void deleteClients(String id) {
		// TODO Auto-generated method stub
		this.clientrepository.delete(id);

	}

}

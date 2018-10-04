package com.thiagosantos.resources;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagosantos.documents.Clients;
import com.thiagosantos.responses.Response;
import com.thiagosantos.services.ClientsService;

@RestController
@RequestMapping(path = "/clients")
public class ClientsResource {
	
	@Autowired
	private ClientsService clientsservice;
	
	@GetMapping
	public ResponseEntity<List<Clients>> findAllClients(){
		return ResponseEntity.ok(this.clientsservice.findAllClients());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Clients> findByIdClients(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(this.clientsservice.findByIdClients(id));
	}
	
	@PostMapping
	public ResponseEntity<Response<Clients>> createClients(@Valid @RequestBody Clients clients, BindingResult result){
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Clients>(errors));
		}
		
		return ResponseEntity.ok(new Response<Clients>(this.clientsservice.createClients(clients)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Clients>> updateClients(@Valid @PathVariable(name = "id")String id, @RequestBody Clients clients, BindingResult result){
		clients.setId(id);
		if(result.hasErrors()) {
			List<String> errors = new ArrayList<String>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Clients>(errors));
		}
		
		return ResponseEntity.ok(new Response<Clients>(this.clientsservice.updateClients(clients)));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> deleteClients(@PathVariable(name = "id")String id){
		this.clientsservice.deleteClients(id);
		return ResponseEntity.ok(1);
		
	}

}

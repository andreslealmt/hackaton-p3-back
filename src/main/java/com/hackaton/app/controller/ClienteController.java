package com.hackaton.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.app.entity.Cliente;
import com.hackaton.app.service.ClienteService;

//import de.mkammerer.argon2.Argon2;
//import de.mkammerer.argon2.Argon2Factory;


@RestController
@RequestMapping("/api/Client/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClienteController {
	
	@Autowired private ClienteService clienteService;
	
	@GetMapping("all")
	public List<Cliente> getClientes(){
		return clienteService.getClientes();
	}
	
	@PostMapping("save")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente saveCliente(@RequestBody Cliente cliente) {
		return clienteService.saveCliente(cliente);
	}
	
	@GetMapping("{id}")
	public Optional<Cliente> getCliente(@PathVariable(value = "id") int idClient){
		return clienteService.getCliente(idClient);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> updateCliente(@RequestBody Cliente cliente){
		Optional<Cliente> newCliente = clienteService.getCliente(cliente.getIdClient());
		if(!newCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}	
		
		
		newCliente.get().setAge(cliente.getAge());		
		newCliente.get().setName(cliente.getName());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.saveClienteUpdate(newCliente.get()));
				
	}
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable int id){
		if(!clienteService.getCliente(id).isPresent()) {
			//return ResponseEntity.notFound().build();
		}
		clienteService.deleteCliente(id);
		//return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

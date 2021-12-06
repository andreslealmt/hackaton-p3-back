package com.hackaton.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hackaton.app.entity.Test;
import com.hackaton.app.service.TestService;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TestController {
	
	@Autowired private TestService testService;
	
	@GetMapping("/all")
	public List<Test> getTests(){
		return testService.getTests();
	}
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	public Test saveTest(@RequestBody Test test) {
		return testService.saveTest(test);
	}
	
	@GetMapping("/{id}")
	public Optional<Test> getTest(@PathVariable int id){
		return testService.getTest(id);
	}
	
	
	
	
	
	
	
	
	
	
	

}

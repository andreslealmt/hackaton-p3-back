package com.hackaton.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.app.entity.Test;
import com.hackaton.app.repository.TestRepository;

@Service
public class TestService {

	@Autowired private TestRepository testRepository;
	
	public List<Test> getTests(){
		return testRepository.findAll();
	}
	
	public Test saveTest(Test test) {
		return testRepository.save(test);
	}
	
	public Optional<Test> getTest(int id){
		return testRepository.findById(id);
	}
	
	
	
	
	
}

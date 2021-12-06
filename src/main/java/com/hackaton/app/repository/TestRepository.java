package com.hackaton.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.app.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer>{

}

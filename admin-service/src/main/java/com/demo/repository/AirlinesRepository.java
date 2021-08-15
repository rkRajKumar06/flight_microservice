package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Airlines;

public interface AirlinesRepository extends JpaRepository<Airlines, Integer> {

}

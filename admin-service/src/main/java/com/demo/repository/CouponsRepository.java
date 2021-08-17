package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Coupons;

public interface CouponsRepository extends JpaRepository<Coupons, Integer> {
	
	public List<Coupons> findByInactive(boolean inactive);
}

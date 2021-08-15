package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Coupons;

public interface CouponsRepository extends JpaRepository<Coupons, Integer> {

}

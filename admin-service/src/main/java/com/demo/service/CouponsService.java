package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Coupons;
import com.demo.repository.CouponsRepository;

@Service
public class CouponsService {
	
	@Autowired
	private CouponsRepository repository;
	
	public List<Coupons> getAllCoupons(){
		return repository.findAll();
	}
	
	public List<Coupons> findAllActiveCoupons(){
		return repository.findByInactive(false);
	}
	
	public Coupons saveCoupon(Coupons coupons) {
		return repository.save(coupons);
	}
	
	public Coupons updateCoupon(int id, Coupons coupons) {
		Optional<Coupons> obj = repository.findById(id);
		if(obj.isPresent()) {
			coupons.setId(id);
			return repository.save(coupons);
		}else {
			throw new AdminServiceException();
		}
	}

}

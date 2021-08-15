package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Coupons;
import com.demo.service.CouponsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coupons")
public class CouponsController {

	@Autowired 
	private CouponsService couponsService;
	
	@GetMapping("")
	public ResponseEntity<List<Coupons>> getAllCoupons(){
		System.out.println(" --backend first call--- ");
		return new ResponseEntity<List<Coupons>>(couponsService.getAllCoupons(), HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Coupons> saveCoupons(@RequestBody Coupons coupons){
		return new ResponseEntity<Coupons>(couponsService.saveCoupon(coupons), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Coupons> saveCoupons(@PathVariable int id, @RequestBody Coupons coupons){
		return new ResponseEntity<Coupons>(couponsService.updateCoupon(id, coupons), HttpStatus.OK);
	}
}

package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cp.model.Amphures;
import com.cp.service.AddressService;

public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		super();
		this.addressService = addressService;
	}

//	@GetMapping("/getAmphuresForProvince")
//	public ResponseEntity<List<Amphures>> getAmphuresForProvince(@RequestParam("province_id") Integer provinceId) {
//	    // Implement logic to retrieve and return a list of amphures for the specified province.
//	    List<Amphures> amphures = addressService.getAmphuresByProvince(provinceId);
//	    return ResponseEntity.ok(amphures);
//	}

}

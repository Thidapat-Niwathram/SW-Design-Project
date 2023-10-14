package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cp.model.Lease;
import com.cp.service.LeaseService;

@Controller
public class LeaseController {
	
	@Autowired
	private LeaseService leaseService;
	
	@Autowired
	public void setLeaseRepository(LeaseService leaseService) {
		this.leaseService = leaseService;
	}
//	
	@GetMapping("/leases")
	public String showAllLease(Model model) {
		List<Lease> lease = leaseService.getAllLeaseRepository();
		model.addAttribute("lease", lease);
		return "leases-owner";
		
	}
	

}

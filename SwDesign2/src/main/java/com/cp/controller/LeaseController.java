package com.cp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cp.model.Lease;
import com.cp.model.Resident;
import com.cp.service.LeaseService;

@Controller
public class LeaseController {

	@Autowired
	private LeaseService leaseService;

	@Autowired
	public void setLeaseRepository(LeaseService leaseService) {
		this.leaseService = leaseService;
	}
	
	@GetMapping("/residents")
    public String showAllResidents(Model model) {
        List<Lease> lease = leaseService.getAllLease();
        model.addAttribute("lease", lease);
        return "residents-owner";

<<<<<<< HEAD
	@GetMapping("/residents-owner")
	public String showAllLease(Model model) {
		List<Lease> lease = leaseService.getAllLeaseRepository();
		model.addAttribute("lease", lease);
		return "residents-owner";

	}

	@GetMapping("/delete_resident/{id}")
	public String deleteResident(@PathVariable("id") Integer id, Model model) {
		Lease lease = leaseService.getLeaseById(id);
		leaseService.deleteLeaseById(id);
		return "redirect:/residents-owner";
	}
=======
    }
	
	@GetMapping("/leases")
	public String showAllLease(Model model) {
		List<Lease> lease = leaseService.getAllLease();
		model.addAttribute("lease", lease);
		return "leases-owner";
		
	}

	
>>>>>>> b0aa2c9d91aa771d6ee972880574514e65d41864
}

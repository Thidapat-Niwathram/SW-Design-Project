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
	
	@GetMapping("/residents")
    public String showAllResidents(Model model) {
        List<Lease> lease = leaseService.getAllLease();
        model.addAttribute("lease", lease);
        return "residents-owner";

    }

	@GetMapping("/leases")
    public String showAllLease(Model model) {
        List<Lease> lease = leaseService.getAllLease();
        model.addAttribute("leases", lease);
        return "leases-owner";

    }
	
	@GetMapping("/add-lease")
	public String addLease() {
		return "add-lease-owner";
	}
	
	@GetMapping("/edit-lease")
	public String editLease(Model model) {
		//get lease by id from leases page and show that value in edit page
		return "edit-lease-owner";
	}
	
	@GetMapping("/delete-lease")
	public String deleteLeaseById(Model model) {
		//delete by id
		return "leases-owner";
	}

	
}

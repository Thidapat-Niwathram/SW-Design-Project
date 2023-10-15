package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cp.model.Bill;
import com.cp.model.Lease;
import com.cp.model.Resident;
import com.cp.service.ResidentService;

@Controller
public class ResidentController {
	
	@Autowired
	private ResidentService residentService;

	@Autowired
	public void setResidentService(ResidentService residentService) {
		this.residentService = residentService;
	}
	
	@RequestMapping("/residents_json")
	@ResponseBody
	public List<Resident> getResidentList() {
		List<Resident> resi = residentService.getAllResident();
		return resi;
	}
	
	@GetMapping("/add-resident")
	public String addResident() {
		return "add-resident-owner";
	}
	
	@GetMapping("/edit-resident")
	public String editResident() {
		return "edit-resident-owner";
	}
	
	@GetMapping("/delete-resident")
	public String deleteResident() {
		//delete by id
		return "residents-owner";
	}
	
	
	


}

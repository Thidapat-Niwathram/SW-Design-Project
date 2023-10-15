package com.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cp.model.Amphures;
import com.cp.model.Bill;
import com.cp.model.Districts;
import com.cp.model.Lease;
import com.cp.model.Provinces;
import com.cp.model.Resident;
import com.cp.service.AddressService;
import com.cp.service.ResidentService;

@Controller
public class ResidentController {
	
	@Autowired
	private ResidentService residentService;
	private AddressService addressService;

	@Autowired
	public void setResidentService(ResidentService residentService) {
		this.residentService = residentService;
	}
	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	@RequestMapping("/residents_json")
	@ResponseBody
	public List<Resident> getResidentList() {
		List<Resident> resi = residentService.getAllResident();
		return resi;
	}
	
	@GetMapping("/add-resident")

	public String getResidentList(Model model) {
		List<Resident> residentList = residentService.getAllResident();
		List<Amphures> amphuresList = addressService.getAllAmphuresRepository();
		List<Districts> districtsList = addressService.getAllDistrictsRepository();
		List<Provinces> provincesList = addressService.getAllProvincesRepository();
		model.addAttribute("residentList", residentList);     
		model.addAttribute("amphuresList", amphuresList); 
		model.addAttribute("districtsList", districtsList); 
		model.addAttribute("provincesList", provincesList); 
		return "add-resident-owner";
	}
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

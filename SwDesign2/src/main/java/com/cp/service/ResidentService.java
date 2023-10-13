package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cp.model.Resident;
import com.cp.repository.LeaseRepository;
import com.cp.repository.ResidentRepository;

public class ResidentService {
	private ResidentRepository residentRepository;
	
	@Autowired
	public void setResidentRepository(ResidentRepository residentRepository) {
		this.residentRepository = residentRepository;
	}

	public ResidentService(ResidentRepository residentRepository) {
		super();
		this.residentRepository = residentRepository;
	}
	
	//get All id
	public List<Resident> getAllResidentRepository(){
		return (List<Resident>) this.residentRepository.findAll();
		}
	//get by id
	public Resident getResidentById(String id) {
		return this.residentRepository.findById(id).get();
	}
	//delete by id
	public void deleteResidentById(String id) {
		Resident resident = this.residentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Resident Id:" + id));
		residentRepository.delete(resident);
	}

}

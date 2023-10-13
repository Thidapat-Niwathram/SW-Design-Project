package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cp.model.Bill;
import com.cp.model.Unit;
import com.cp.repository.BillRepository;
import com.cp.repository.UnitRepository;

public class UnitService {

	private UnitRepository unitRepo;
	@Autowired
	public void setUnitRepository(UnitRepository unitRepository) {
		this.unitRepo = unitRepository;
	}
	public List<Unit> getUnitAll() {
		return (List<Unit>) this.unitRepo.findAll();
	}

	public Unit getUnitById(Integer id) {
		return this.unitRepo.findById(id).get();
	}

	public void deletUnitById(Integer id) {
		Unit unit = this.unitRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
				unitRepo.delete(unit);
	}
	public void saveUnit(Unit unit) {
		 this.unitRepo.save(unit);
	 }
}

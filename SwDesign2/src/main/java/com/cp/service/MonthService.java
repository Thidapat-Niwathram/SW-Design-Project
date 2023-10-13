package com.cp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cp.model.Bill;
import com.cp.model.Month;
import com.cp.repository.BillRepository;
import com.cp.repository.MonthRepository;
import com.cp.repository.UnitRepository;

public class MonthService {

	private MonthRepository monthRepo;

	@Autowired
	public void setMonthRepository(MonthRepository monthRepository) {
		this.monthRepo = monthRepository;
	}
	
	public List<Month> getMonthAll() {
		return (List<Month>) this.monthRepo.findAll();
	}

	public Month getMonthById(Long id) {
		return this.monthRepo.findById(id).get();
	}

	public void deletMonthById(Long id) {
		Month month = this.monthRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
				monthRepo.delete(month);
	}
	public void saveMonth(Month month) {
		 this.monthRepo.save(month);
	 }
	
}

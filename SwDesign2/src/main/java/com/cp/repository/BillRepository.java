package com.cp.repository;

import org.springframework.data.repository.CrudRepository;

import com.cp.model.Bill;


public interface BillRepository extends CrudRepository<Bill,Integer> {

}

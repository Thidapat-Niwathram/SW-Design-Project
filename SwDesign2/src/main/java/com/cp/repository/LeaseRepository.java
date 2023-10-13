package com.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.model.Lease ;

public interface LeaseRepository extends JpaRepository<Lease,Integer>{

}

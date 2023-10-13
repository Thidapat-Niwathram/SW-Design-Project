package com.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cp.model.Resident;

public interface ResidentRepository extends JpaRepository<Resident,String> {

}

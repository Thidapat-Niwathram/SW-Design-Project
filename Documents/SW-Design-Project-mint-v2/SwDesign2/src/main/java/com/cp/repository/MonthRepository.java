package com.cp.repository;
import java.util.Date;
import org.springframework.data.repository.CrudRepository;


import com.cp.model.Month;

public interface MonthRepository extends CrudRepository<Month,Date>{

}

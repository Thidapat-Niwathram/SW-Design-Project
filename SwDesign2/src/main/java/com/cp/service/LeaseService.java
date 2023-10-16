package com.cp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.model.Bill;
import com.cp.model.Lease;
import com.cp.model.Resident;
import com.cp.model.Room;
import com.cp.model.Type;
import com.cp.repository.LeaseRepository;
import com.cp.repository.ResidentRepository;
import com.cp.repository.RoomRepository;
import com.cp.repository.TypeRepository;

@Service
public class LeaseService {

	private LeaseRepository leaseRepository;

	@Autowired
	public void setLeaseRepository(LeaseRepository leaseRepository) {
		this.leaseRepository = leaseRepository;
	}

	@Autowired
	public LeaseService(LeaseRepository leaseRepository, ResidentRepository residentRepository,
			RoomRepository roomRepository, TypeRepository typeRepository) {
		super();
		this.leaseRepository = leaseRepository;
	}

	// get all
	public List<Lease> getAllLease() {
		return (List<Lease>) this.leaseRepository.findAll();
	}

	// get by id
	public Lease getLeaseById(Integer id) {
		return this.leaseRepository.findById(id).get();
	}

	// delete by id
	public void deleteLeaseById(Integer id) {
		Lease lease = this.leaseRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Lease Id:" + id));
		leaseRepository.delete(lease);
	}

	public void saveLeaseById(Lease l) {
		this.leaseRepository.save(l);
	}

	public void saveLease(Lease l) {
		this.leaseRepository.save(l);
	}

	public Bill findLatestBill(Lease lease) {
        if (lease != null) {
            List<Bill> bills = lease.getBill();
            if (!bills.isEmpty()) {
                // Use Java Stream to find the Bill with the latest pay_date
                return bills.stream()
                    .max(Comparator.comparing(bill -> bill.getMonth().getPay_date()))
                    .orElse(null);
            }
        }
        return null; // Or handle the case when the lease or bills don't exist
    }

}

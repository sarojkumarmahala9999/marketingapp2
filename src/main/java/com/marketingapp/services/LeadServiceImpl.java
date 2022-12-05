package com.marketingapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.Repository.LeadRepository;
import com.marketingapp.entities.Lead;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(Lead l) {
		leadRepo.save(l);
	}

	@Override
	public List<Lead> listAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteOneLead(Long id) {
		leadRepo.deleteById(id);
	}

	@Override
	public Lead updateLead(Long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

}

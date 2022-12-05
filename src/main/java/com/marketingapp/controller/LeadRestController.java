package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketingapp.Repository.LeadRepository;
import com.marketingapp.entities.Lead;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	//getmapping get all data from db as java object and convert that into JSON object
	@GetMapping
	public List<Lead> getAllLeads(){
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	
	//requestbody helps us to read the JSON object and put that in java object
	@PostMapping
	public void saveLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	//putmapping helps us to update the record from the db by using api
	@PutMapping
	public void updateLead(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	
	//http://localhost:8080/api/leads/delete/16
	@DeleteMapping("/delete/{id}")
	public void deleteLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
	}
}

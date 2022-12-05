package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;
import com.marketingapp.util.EmailService;

@Controller
public class LeadController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private LeadService leadService;
	
	@RequestMapping("/viewLeadPage")
	public String viewCreateLeadPage() {
		return "create_lead";
	}
	
	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
	public String saveLead(@ModelAttribute("lead") Lead l, ModelMap model) {
		leadService.saveOneLead(l);
		emailService.sendSimpleMail(l.getEmail(), "Test", "Record is saved!!");
		model.addAttribute("msg", "Record Saved!!");
		return "create_lead";
	}
	
	@RequestMapping("/listAllleads")
	public String listAllLeads(ModelMap model) {
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/deleteLead")
	public String deleteLead(@RequestParam("id") Long id, ModelMap model) {
		leadService.deleteOneLead(id);
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		model.addAttribute("msg", "One Lead Deleted!!");
		return "list_leads";
	}
	
	@RequestMapping("/updateLead")
	public String updateLead(@RequestParam("id") Long id, ModelMap model) {
		Lead lead = leadService.updateLead(id);
		model.addAttribute("lead", lead);
		return "update_lead";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateOneLead(@ModelAttribute("lead") Lead l, ModelMap model) {
		leadService.saveOneLead(l);
		List<Lead> leads = leadService.listAllLeads();
		model.addAttribute("leads", leads);
		model.addAttribute("value", "Record Updated Successfully!!!");
		return "list_leads";
	}
	
}

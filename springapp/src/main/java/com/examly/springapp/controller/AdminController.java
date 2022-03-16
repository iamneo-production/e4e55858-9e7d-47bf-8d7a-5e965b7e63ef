package com.example.ugadmissions.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ugadmissions.models.InstituteModel;
import com.example.ugadmissions.repos.InstituteRepo;

@RestController
public class AdminController {
	
	@Autowired
	InstituteRepo repo;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/viewInstitutes")
	public List<InstituteModel> viewInstitute() {
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addInstitute")
	public InstituteModel addInstitute(@RequestBody InstituteModel institute) {
		return repo.save(institute);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteInstitute/{InstituteId}")
	public void deleteInstitute(@PathVariable int InstituteId) {
		repo.deleteById(InstituteId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/editInstitute/{instituteId}")
	public void editInstitute(@RequestBody InstituteModel institute,@PathVariable int instituteId) {
		if(repo.findById(instituteId) != null)
		repo.save(institute);
	}
}

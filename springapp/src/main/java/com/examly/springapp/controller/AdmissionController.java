package com.examly.springapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Admission;
import com.examly.springapp.model.AdmissionStatus;
import com.examly.springapp.model.Student;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.AdmissionRepository;
import com.examly.springapp.repository.AdmissionStatusRepository;
import com.examly.springapp.repository.StudentRepository;
import com.examly.springapp.repository.UserRepository;

import antlr.collections.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdmissionController {
	
	
	@Autowired
	private AdmissionRepository admrepo;
	
	@Autowired
	private AdmissionStatusRepository asr;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private StudentRepository stur;
	
	@PostMapping("/saveAdmission/{userId}")
	public ResponseEntity<Object> saveAdmission(@PathVariable("userId") Long userid,@RequestBody Admission admission)
	{
		User user=userrepo.findById(userid).get();
		user.setAdmission(admission);
		AdmissionStatus adms=new AdmissionStatus(1, null);
	    admission.setAdmissionStatus(adms);
		return ResponseEntity.ok(this.userrepo.save(user));
	}
	
	@GetMapping("/getadmissions")
	public ResponseEntity<Object> getAdmissions(){
		return ResponseEntity.ok(this.admrepo.findAll());
	}
	@GetMapping("/getadmission/{admissionId}")
	public ResponseEntity<Admission> getAdmission(@PathVariable Integer admissionId){
		return ResponseEntity.ok(this.admrepo.findById(admissionId).get());
	}
	
	@GetMapping("/approved")
	public ResponseEntity<?> getApproved(){
		return ResponseEntity.ok(this.admrepo.getApplication("APPROVED"));
	}
	
	@GetMapping("/pending")
	public ResponseEntity<?> getPending(){
		return ResponseEntity.ok(this.admrepo.getApplication("PENDING"));
	}
	
	@GetMapping("/rejected")
	public ResponseEntity<?> getRejected(){
		return ResponseEntity.ok(this.admrepo.getApplication("REJECTED"));
	}
	
	 @PutMapping("/editadmission")
	 public ResponseEntity<Object> editAdmission(@RequestBody Admission admission){
		 Student student=admission.getStudent();
		 stur.save(student);
		 return ResponseEntity.ok(this.admrepo.save(admission));
	 }
	
	
	@PutMapping("/approve/{admissionId}")
	public ResponseEntity<Object> approveApplication(@PathVariable Integer admissionId){
		Admission admission=admrepo.findById(admissionId).get();
		AdmissionStatus adms=new AdmissionStatus(2, null);
		admission.setAdmissionStatus(adms);	
		return ResponseEntity.ok(admrepo.save(admission));
	}
	@PutMapping("/reject/{admissionId}")
	public ResponseEntity<Object> rejectApplication(@PathVariable Integer admissionId){
		Admission admission=admrepo.findById(admissionId).get();
		AdmissionStatus adms=new AdmissionStatus(3, null);
		admission.setAdmissionStatus(adms);	
		return ResponseEntity.ok(admrepo.save(admission));
	}
	
//	@PutMapping("/approving/{id}")
//	public ResponseEntity<?> approveApplication(@PathVariable Integer id) throws Exception{
//		Admission imc=admrepo.findById(id).orElseThrow(()->new Exception("Admission not found"));
//		
//		
//		AdmissionStatus admissionstatus=new AdmissionStatus();
//		
//    	admissionstatus.setAdmissionStatusId(2);
//    	admissionstatus.setStatusName("approved");
//    	if(checkStatusExist(admissionstatus.getAdmissionStatusId()))
//    	{
//    		asr.save(admissionstatus);
//    	}
//    	imc.setAdmissionStatus(admissionstatus);
//		
//		Admission updated=admrepo.save(imc);
//		
//		return ResponseEntity.ok(updated);
//	}
//	
//	@PutMapping("/approvings/{id}")
//	public ResponseEntity<?> approveApplications(@PathVariable Integer id,@RequestBody Admission admission) throws Exception{
//		Admission imc=admrepo.findById(id).orElseThrow(()->new Exception("Admission not found"));
//		
//		
//		AdmissionStatus admissionstatus=new AdmissionStatus();
//		
//    	admissionstatus.setAdmissionStatusId(2);
//    	admissionstatus.setStatusName("approved");
//    	if(checkStatusExist(admissionstatus.getAdmissionStatusId()))
//    	{
//    		asr.save(admissionstatus);
//    	}
//    	imc.setAdmissionStatus(admissionstatus);
//		
//		Admission updated=admrepo.save(imc);
//		
//		return ResponseEntity.ok(updated);
//	}
	
//	@PutMapping("/rejecting/{id}")
//	public ResponseEntity<?> rejectApplication(@PathVariable Integer id) throws Exception{
//		Admission imc=admrepo.findById(id).orElseThrow(()->new Exception("Admission not found"));
//		
//		AdmissionStatus admissionstatus=new AdmissionStatus();
//		
//    	admissionstatus.setAdmissionStatusId(3);
//    	admissionstatus.setStatusName("rejected");
//    	if(checkStatusExist(admissionstatus.getAdmissionStatusId()))
//    	{
//    		asr.save(admissionstatus);
//    	}
//    	imc.setAdmissionStatus(admissionstatus);
//		
//		Admission updated=admrepo.save(imc);
//		
//		return ResponseEntity.ok(updated);
//	}
   
//    public Boolean checkStatusExist(Integer i){
//    	return asr.findById(i)!=null?false:true;
//    }
}

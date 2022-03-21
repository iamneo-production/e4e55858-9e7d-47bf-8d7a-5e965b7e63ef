package com.examly.springapp.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.Exception.ResourceNotFoundException;
// import com.example.demo.Model.FeedBack;
// import com.example.demo.Repository.FeedBackRepository;



@RestController
@RequestMapping("/api/v1/")
public class FeedBackController {
	// @Autowired
	// private FeedBackRepository FeedBackRepository;
	
	// //get all feedBack
	// @GetMapping("/feedback")
	// @CrossOrigin(origins="http://localhost:4200")
	// public List<FeedBack> getAllFeedBack(){
	// 	return FeedBackRepository.findAll(); 
	// }
	
	// //Submit feedback
	// @PostMapping("/feedback")
	// @CrossOrigin(origins="http://localhost:4200")
	// public FeedBack createFeedBack(@RequestBody FeedBack feedback){
	// 	return FeedBackRepository.save(feedback);
	// }
	
	// //Get single feedBack
	// @GetMapping("/feedback/{id}")
	// @CrossOrigin(origins="http://localhost:4200")
	// public ResponseEntity<FeedBack>getFeedBackById(@PathVariable Long id){
	// 	FeedBack feedback = FeedBackRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Feedback doesn't exist with id:"+id));
	// 	return ResponseEntity.ok(feedback);
	// }
	
	// //Update FeedBack
	// @PutMapping("/feedback/{id}")
	// @CrossOrigin(origins="http://localhost:4200")
	// public ResponseEntity<FeedBack> UpdateFeedBack(@PathVariable Long id,@RequestBody FeedBack feedbackdetails){
	// 	FeedBack feedback = FeedBackRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Feedback doesn't exist with id:"+id));
	// 	feedback.setName(feedbackdetails.getName());
	// 	feedback.setRating(feedbackdetails.getRating());
	// 	feedback.setTextarea(feedbackdetails.getTextarea());
		
	// 	FeedBack updatedFeedBack=FeedBackRepository.save(feedback);
	// 	return ResponseEntity.ok(updatedFeedBack);
	// }
	
	// //Delete FeedBack
	// @DeleteMapping("/feedback/{id}")
	// @CrossOrigin(origins="http://localhost:4200")
	// public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
	// 	FeedBack feedback = FeedBackRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Feedback doesn't exist with id:"+id));
	// 	FeedBackRepository.delete(feedback);
	// 	Map<String,Boolean> response=new HashMap<>();
	// 	response.put("Deleted", Boolean.TRUE);
	// 	return ResponseEntity.ok(response);
	// }
}

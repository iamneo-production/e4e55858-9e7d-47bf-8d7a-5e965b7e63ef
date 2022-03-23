package com.examly.springapp.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.examly.springapp.model.User;
import com.examly.springapp.model.Rating;
import com.examly.springapp.repository.UserRepository;
import com.examly.springapp.repository.RatingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "*")
public class RatingController {

    @Autowired
    private UserRepository userrepo;

    @PostMapping("/addReview/{userId}")
	public ResponseEntity<Object> addReview(@PathVariable("userId") Long userId,@RequestBody Rating review) {
		User user=this.userrepo.findById(userId).get();
        user.setRating(review);
		return ResponseEntity.ok(userrepo.save(user));
	}

    @Autowired
	private RatingRepository raterepo;


	@GetMapping("/averageRate")
	public ResponseEntity<String> findAvg(@RequestParam("instituteId") int instituteId) {
		String avgrate=this.raterepo.findAvgRate(instituteId);
		if(avgrate==null) {
			return ResponseEntity.ok("0");
		}
		avgrate=avgrate.substring(0, 4);
		return ResponseEntity.ok(avgrate);
	}
    
}

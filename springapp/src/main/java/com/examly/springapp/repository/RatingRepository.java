package com.examly.springapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examly.springapp.model.Rating;

public interface RatingRepository extends JpaRepository<Rating,Integer>{

    @Query(value="select avg(rating) from rating where institute_iid=:instituteid",nativeQuery=true)
	public String findAvgRate(@Param("instituteid") int instituteId);
    
}

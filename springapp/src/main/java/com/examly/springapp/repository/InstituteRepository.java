package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.examly.springapp.model.InstituteModel;
import java.util.List;

@Repository
public interface InstituteRepository extends JpaRepository<InstituteModel, Integer>{

    @Query(value="select institute_Id from institute where institute_Id=5",nativeQuery=true)
	public List<Object> getonly();
}

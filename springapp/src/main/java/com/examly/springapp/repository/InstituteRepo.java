package com.example.ugadmissions.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ugadmissions.models.InstituteModel;

@Repository
public interface InstituteRepo extends JpaRepository<InstituteModel, Integer>{
}

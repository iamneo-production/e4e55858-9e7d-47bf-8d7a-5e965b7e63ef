package com.examly.springapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.DatabaseTranscationException;
import com.examly.springapp.model.InstituteModel;
import com.examly.springapp.repository.InstituteRepository;

@Service
public class InstituteService {
	@Autowired
	private InstituteRepository instituterepo;

	public List<InstituteModel> findall()
	{
		return instituterepo.findAll();
	}

	public InstituteModel save(InstituteModel institute) {
		return instituterepo.save(institute);
	}

	public boolean findById(int instituteId) {
		Optional<InstituteModel> institute=instituterepo.findById(instituteId);
		if(institute.isPresent()) {
			return true;
		}
		return false;
	}

	public Boolean delete(int instituteId) {
		instituterepo.deleteById(instituteId);
	   return true;
	}

	public InstituteModel getInstitute(Integer instituteId) {
		InstituteModel institute=instituterepo.findById(instituteId).get();
		return institute;
	}
	

}

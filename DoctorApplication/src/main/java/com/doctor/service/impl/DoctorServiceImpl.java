package com.doctor.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.entity.Doctor;
import com.doctor.repo.DoctorRepo;
import com.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepo doctorRepository;

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(Long id) {
		Optional<Doctor> doctor = doctorRepository.findById(id);
		return doctor.orElse(null); 
	}

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Long id, Doctor doctor) {
		Optional<Doctor> existingDoctor = doctorRepository.findById(id);
		if (existingDoctor.isPresent()) {
			doctor.setId(id);
			return doctorRepository.save(doctor);
		}
		return null;
	}

	@Override
	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}
}
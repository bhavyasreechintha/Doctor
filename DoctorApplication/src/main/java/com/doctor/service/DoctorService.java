package com.doctor.service;

import java.util.List;

import com.doctor.entity.Doctor;

public interface DoctorService {

	List<Doctor> getAllDoctors();

	Doctor getDoctorById(Long id);

	Doctor saveDoctor(Doctor doctor);

	Doctor updateDoctor(Long id, Doctor doctor);

	void deleteDoctor(Long id);

}
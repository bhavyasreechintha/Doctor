package com.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doctor.entity.Doctor;
import com.doctor.service.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	DoctorService service;

	@GetMapping("/list")
	public String getAllDoctors(Model model) {
		List<Doctor> doctors = service.getAllDoctors();
		model.addAttribute("doctors", doctors);
		return "doctorlist";
	}

	@GetMapping("/add")
	public String showAddDoctorForm(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "add_doctor";
	}

	@PostMapping("/save")
	public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {
		service.saveDoctor(doctor);
		return "redirect:/doctors/list";
	}

	@GetMapping("/edit/{id}")
	public String showEditDoctorForm(@PathVariable Long id, Model model) {
		Doctor doctor = service.getDoctorById(id);
		model.addAttribute("doctor", doctor);
		return "edit_doctor";
	}

	@PostMapping("/update/{id}")
	public String updateDoctor(@PathVariable Long id, @ModelAttribute("doctor") Doctor doctor) {
		service.updateDoctor(id, doctor);
		return "redirect:/doctors/list";
	}
	


	@GetMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable Long id) {
	    service.deleteDoctor(id);
	    return "redirect:/doctors/list";
	}

}
package org.sid.springmvc.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {
	
	@Autowired
	private PatientRepository patientRepository;
	
@GetMapping(path="/index")	
public String index() {
		return "index";
	}
@GetMapping(path="/patients")
public String list(Model model,
		@RequestParam(name="page", defaultValue = "0")int page,
		@RequestParam(name="size", defaultValue = "5") int size,
		@RequestParam(name="keyword",defaultValue = "") String mc) {
	
	Page<Patient> pagePatients=patientRepository.findByNomContains(mc, PageRequest.of(page, size));
	model.addAttribute("patients",pagePatients.getContent());
	model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
	model.addAttribute("currentPage",page);
	model.addAttribute("keyword",mc);
	model.addAttribute("size",size);
			return "patients";
}
@GetMapping(path="/deletePatient")	
public String delete(Long id,int page,int size,String keyword) {
	patientRepository.deleteById(id);
		return "redirect:/patients?page="+page+"&size="+size+"&keyword="+keyword;
	}

@GetMapping(path="/formPatient")	
public String formPatient(Model model) {
	model.addAttribute("patient",new Patient());
		return "formPatient";
	}

@PostMapping(path="/savePatient")	
public String savePatient(@Valid Patient patient,BindingResult bindingResult,Model model) {
	if(bindingResult.hasErrors()) return "formPatient";
	patientRepository.save(patient);
	model.addAttribute(patient);
		return "confirmation";
	}

@GetMapping(path="/editPatient")	
public String editPatient(Model model,Long id) {
	Patient patient=patientRepository.findById(id).get();
	model.addAttribute("patient",patient);
		return "formPatient";
	}

}





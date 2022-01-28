package org.sid.springmvc;

import java.util.Date;

import org.sid.springmvc.dao.PatientRepository;
import org.sid.springmvc.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcApplication implements CommandLineRunner{
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"youssef",new Date(),false,10));
		patientRepository.save(new Patient(null,"aymen",new Date(),false,20));
		patientRepository.save(new Patient(null,"simo",new Date(),true,30));
		patientRepository.save(new Patient(null,"noumane",new Date(),false,40));
		patientRepository.save(new Patient(null,"youssef",new Date(),false,77));
		patientRepository.save(new Patient(null,"aymen",new Date(),false,7));
		patientRepository.save(new Patient(null,"simo",new Date(),true,6));
		patientRepository.save(new Patient(null,"noumane",new Date(),false,55));
		patientRepository.save(new Patient(null,"youssef",new Date(),false,140));
		patientRepository.save(new Patient(null,"aymen",new Date(),false,11));
		patientRepository.save(new Patient(null,"simo",new Date(),true,56));
		patientRepository.save(new Patient(null,"noumane",new Date(),false,77));
		patientRepository.save(new Patient(null,"youssef",new Date(),false,10));
		patientRepository.save(new Patient(null,"youssef",new Date(),false,465));
		patientRepository.save(new Patient(null,"youssef",new Date(),false,10));
		patientRepository.save(new Patient(null,"youssef",new Date(),false,9));
		
		patientRepository.findAll().forEach(p->{
			System.out.println(p.getNom());
		});
	}

}

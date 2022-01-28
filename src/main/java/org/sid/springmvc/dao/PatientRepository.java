package org.sid.springmvc.dao;


import org.springframework.data.domain.Pageable;

import org.sid.springmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	public Page<Patient> findByNomContains(String mc,Pageable pageable);
}

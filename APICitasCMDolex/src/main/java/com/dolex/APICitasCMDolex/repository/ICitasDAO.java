package com.dolex.APICitasCMDolex.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolex.APICitasCMDolex.entity.CitasEntity;

public interface ICitasDAO extends JpaRepository<CitasEntity, Integer> {
	
	List<CitasEntity> findByDoctorIDAndFechaCita(Integer doctorID, LocalDate fechaCita);

}

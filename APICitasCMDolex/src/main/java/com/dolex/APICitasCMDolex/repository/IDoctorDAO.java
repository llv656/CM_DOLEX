package com.dolex.APICitasCMDolex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolex.APICitasCMDolex.entity.DoctorEntity;

public interface IDoctorDAO extends JpaRepository<DoctorEntity, Integer> {

}

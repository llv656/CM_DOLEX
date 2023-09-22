package com.dolex.APICitasCMDolex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolex.APICitasCMDolex.entity.CitasEntity;

public interface ICitasDAO extends JpaRepository<CitasEntity, Integer> {

}

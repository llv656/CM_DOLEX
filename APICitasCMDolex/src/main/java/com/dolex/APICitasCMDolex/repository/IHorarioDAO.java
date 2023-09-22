package com.dolex.APICitasCMDolex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dolex.APICitasCMDolex.entity.HorarioXDiaEntity;

public interface IHorarioDAO extends JpaRepository<HorarioXDiaEntity, Integer> {

}

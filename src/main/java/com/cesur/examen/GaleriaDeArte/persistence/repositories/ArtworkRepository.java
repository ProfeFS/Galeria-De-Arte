package com.cesur.examen.GaleriaDeArte.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtworkEntity;

public interface ArtworkRepository extends JpaRepository<ArtworkEntity, Integer>{

}

package com.cesur.examen.GaleriaDeArte.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtistEntity;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer>{

}

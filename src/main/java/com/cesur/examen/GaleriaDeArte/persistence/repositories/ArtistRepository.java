package com.cesur.examen.GaleriaDeArte.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtistEntity;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer>{

}

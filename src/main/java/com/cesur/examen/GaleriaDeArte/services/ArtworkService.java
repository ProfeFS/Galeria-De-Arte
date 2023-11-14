package com.cesur.examen.GaleriaDeArte.services;

import java.util.ArrayList;
import java.util.List;

import com.cesur.examen.GaleriaDeArte.domain.ArtworkDTO;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtworkEntity;

public interface ArtworkService {

	List<ArtworkDTO> getAllArtworks();

	void createArtwork(ArtworkDTO artworkDTO);

}

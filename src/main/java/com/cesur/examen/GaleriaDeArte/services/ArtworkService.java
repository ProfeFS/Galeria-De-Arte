package com.cesur.examen.GaleriaDeArte.services;

import java.util.ArrayList;

import com.cesur.examen.GaleriaDeArte.domain.ArtworkDTO;

public interface ArtworkService {

	ArrayList<ArtworkDTO> getAllArtworks();
	
	void createArtwork(ArtworkDTO artworkDTO);

}

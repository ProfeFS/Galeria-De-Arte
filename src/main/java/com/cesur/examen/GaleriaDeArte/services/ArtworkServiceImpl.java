package com.cesur.examen.GaleriaDeArte.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.examen.GaleriaDeArte.domain.ArtworkDTO;
import com.cesur.examen.GaleriaDeArte.exceptions.ArtworkCreationException;

@Service
public class ArtworkServiceImpl implements ArtworkService {

	ArrayList<ArtworkDTO> obras = new ArrayList<>();

	ArtworkDTO ar = new ArtworkDTO(1, "Titulo1", "hola soy la descripción uno", 1);
	ArtworkDTO ar2 = new ArtworkDTO(2, "Titulo2", "hola soy la descripción dos", 2);
	ArtworkDTO ar3 = new ArtworkDTO(3, "Titulo3", "hola soy la descripción tres", 1);
	ArtworkDTO ar4 = new ArtworkDTO(4, "Titulo4", "hola soy la descripción cuatro", 3);

	@Autowired
	ArtistService artistService;

	public ArtworkServiceImpl() {
		obras.add(ar);
		obras.add(ar2);
		obras.add(ar3);
		obras.add(ar4);		
	}

	@Override
	public ArrayList<ArtworkDTO> getAllArtworks() {

		return obras;
	}

	@Override
	public void createArtwork(ArtworkDTO artworkDTO) {

		if (artistService.getArtistById(artworkDTO.getArtistId()) != null) {
			ArtworkDTO artwork = new ArtworkDTO(artworkDTO.getId(), artworkDTO.getTitle(), artworkDTO.getDescription(),
					artworkDTO.getArtistId());
			
			obras.add(artwork);
			

		} else {
			throw new ArtworkCreationException(
					"El artista que ha creado esa obra no puede ingresar obras de arte en neustra galería");
		}

	}

}

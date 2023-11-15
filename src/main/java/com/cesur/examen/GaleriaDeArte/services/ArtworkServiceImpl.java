package com.cesur.examen.GaleriaDeArte.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cesur.examen.GaleriaDeArte.domain.ArtworkDTO;
import com.cesur.examen.GaleriaDeArte.exceptions.ArtworkCreationException;
import com.cesur.examen.GaleriaDeArte.mappers.ArtworkMapper;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtworkEntity;
import com.cesur.examen.GaleriaDeArte.persistence.repositories.ArtworkRepository;

@Service
public class ArtworkServiceImpl implements ArtworkService {

	@Autowired()
	ArtistService artistService;
	@Autowired
	ArtworkRepository artworkRepository;
	@Autowired
	ArtworkMapper artworkMapper;

	@Override
	public List<ArtworkDTO> getAllArtworks() {

		List<ArtworkEntity> Artworks = artworkRepository.findAll();
		// List<ArtworkDTO> artworkDTOs = new ArrayList<>();

//		for(ArtworkEntity e : Artworks ) {
//			ArtworkDTO artworkDTO = new ArtworkDTO(e.getId(), e.getTitle(), e.getDescription(), e.getArtistId());
//			artworkDTOs.add(artworkDTO);
//		}
//		
//		return artworkDTOs;

		return artworkMapper.mapEntityListToDToList(Artworks);

	}

	@Override
	public void createArtwork(ArtworkDTO artworkDTO) {

		if (artistService.getArtistById(artworkDTO.getArtistId()) != null) {

			ArtworkEntity artworkEntity = new ArtworkEntity();
			artworkEntity.setArtistId(artworkDTO.getArtistId());
			artworkEntity.setDescription(artworkDTO.getDescription());
			artworkEntity.setTitle(artworkDTO.getTitle());

			artworkRepository.save(artworkEntity);

//			ArtworkDTO artwork = new ArtworkDTO(artworkDTO.getId(), artworkDTO.getTitle(), artworkDTO.getDescription(),
//					artworkDTO.getArtistId());			
//			obras.add(artwork);

		} else {
			throw new ArtworkCreationException(
					"El artista que ha creado esa obra no puede ingresar obras de arte en nuestra galería");
		}

	}

}

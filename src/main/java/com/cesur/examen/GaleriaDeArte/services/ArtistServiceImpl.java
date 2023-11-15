package com.cesur.examen.GaleriaDeArte.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cesur.examen.GaleriaDeArte.domain.ArtistDTO;
import com.cesur.examen.GaleriaDeArte.mappers.ArtistMapper;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtistEntity;
import com.cesur.examen.GaleriaDeArte.persistence.repositories.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

	ArtistRepository artistRepository;
	ArtistMapper artistMapper;

	public ArtistServiceImpl(ArtistRepository artistRepository,
			ArtistMapper artistMapper) {	
		
		this.artistRepository = artistRepository;
		this.artistMapper = artistMapper;
	}

	@Override
	public ArtistDTO getArtistById(Integer id) {

		Optional<ArtistEntity> artist = artistRepository.findById(id);

		if (artist.isPresent()) {
//			ArtistDTO artistDTO = new ArtistDTO();
//			artistDTO.setId(artist.get().getId());
//			artistDTO.setNombre(artist.get().getNombre());
//			return artistDTO;
			
			return artistMapper.mapEntityToDTO(artist.get());

		}

		return null;

	}

	@Override
	public ArtistDTO create(ArtistDTO artistDTO) {

//		ArtistEntity artistE = new ArtistEntity();
//		artistE.setNombre(artistDTO.getNombre());		
//		artistE = artistRepository.save(artistE);
//		return new ArtistDTO(artistE.getId(), artistE.getNombre());
		
		ArtistEntity artistE = artistRepository.save(artistMapper.mapDtoToEntity(artistDTO));
		return artistMapper.mapEntityToDTO(artistE);
		

	}

}

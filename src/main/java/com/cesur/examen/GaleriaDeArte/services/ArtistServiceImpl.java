package com.cesur.examen.GaleriaDeArte.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cesur.examen.GaleriaDeArte.domain.ArtistDTO;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtistEntity;
import com.cesur.examen.GaleriaDeArte.persistence.repositories.ArtistRepository;

@Service
public class ArtistServiceImpl implements ArtistService {

	ArrayList<ArtistDTO> artists = new ArrayList<>();

	ArtistDTO ar = new ArtistDTO(1, "Goya");
	ArtistDTO ar2 = new ArtistDTO(2, "Picasso");
	ArtistDTO ar3 = new ArtistDTO(3, "Dalí");
	ArtistDTO ar4 = new ArtistDTO(4, "Miró");

	ArtistRepository artistRepository;

	public ArtistServiceImpl(ArtistRepository artistRepository) {
		artists.add(ar);
		artists.add(ar2);
		artists.add(ar3);
		artists.add(ar4);
		this.artistRepository = artistRepository;
	}

	@Override
	public ArtistDTO getArtistById(Integer id) {

//		for(ArtistDTO artist : artists) {
//			if(artist.getId() == id) {
//				return artist;				
//			}			
//		}	

		Optional<ArtistEntity> artist = artistRepository.findById(id);

		if (artist.isPresent()) {
			ArtistDTO artistDTO = new ArtistDTO();
			artistDTO.setId(artist.get().getId());
			artistDTO.setNombre(artist.get().getNombre());
			return artistDTO;

		}

		return null;

	}

	@Override
	public ArtistDTO create(ArtistDTO artistDTO) {
		
		ArtistEntity artistE = new ArtistEntity();
		artistE.setNombre(artistDTO.getNombre());
		artistE = artistRepository.save(artistE);
		return new ArtistDTO(artistE.getId(), artistE.getNombre());

	}

}

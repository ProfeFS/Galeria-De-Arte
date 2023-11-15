package com.cesur.examen.GaleriaDeArte.mappers;

import org.mapstruct.Mapper;

import com.cesur.examen.GaleriaDeArte.domain.ArtistDTO;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtistEntity;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
	
	public ArtistDTO mapEntityToDTO(ArtistEntity aEnt);
	
	public ArtistEntity mapDtoToEntity(ArtistDTO aDto);

}

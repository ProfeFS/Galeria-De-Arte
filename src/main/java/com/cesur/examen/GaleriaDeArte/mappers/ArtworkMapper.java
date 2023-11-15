package com.cesur.examen.GaleriaDeArte.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cesur.examen.GaleriaDeArte.domain.ArtworkDTO;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtworkEntity;

@Mapper(componentModel = "spring")
public interface ArtworkMapper {
	
	public ArtworkDTO mapEntityToDTO(ArtworkEntity awe);
	
	public ArtworkEntity mapDtoToEntity(ArtworkDTO awd);
	
	public List<ArtworkDTO> mapEntityListToDToList(List<ArtworkEntity> artworks);
	

}

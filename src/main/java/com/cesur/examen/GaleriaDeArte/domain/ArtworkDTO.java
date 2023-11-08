package com.cesur.examen.GaleriaDeArte.domain;

import com.cesur.examen.GaleriaDeArte.validators.ArtworkDescription;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtworkDTO {
	Integer id;
	String title;
	
	@ArtworkDescription
	String description;
	Integer artistId;

}

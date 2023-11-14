package com.cesur.examen.GaleriaDeArte.domain;

import com.cesur.examen.GaleriaDeArte.validators.ArtworkDescription;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ArtworkDTO {
	Integer id;
	String title;
	
	@ArtworkDescription
	String description;
	Integer artistId;

}

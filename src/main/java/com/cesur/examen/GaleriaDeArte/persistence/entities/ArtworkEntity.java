package com.cesur.examen.GaleriaDeArte.persistence.entities;

import com.cesur.examen.GaleriaDeArte.validators.ArtworkDescription;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Artwork")
public class ArtworkEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Integer id;
	
	String title;
	
	@ArtworkDescription
	String description;
	Integer artistId;

}

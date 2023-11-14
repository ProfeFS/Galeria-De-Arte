package com.cesur.examen.GaleriaDeArte.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cesur.examen.GaleriaDeArte.domain.ArtistDTO;
import com.cesur.examen.GaleriaDeArte.persistence.entities.ArtistEntity;
import com.cesur.examen.GaleriaDeArte.services.ArtistService;

@RestController
@RequestMapping("/artists")
public class ArtistRestController {

	@Autowired
	ArtistService artistService;

	@PostMapping
	ResponseEntity<?> create(@RequestBody ArtistDTO artist) {

		ArtistDTO artistDTO = artistService.create(artist);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + artistDTO.getId())
				.buildAndExpand(artistDTO.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/{artistId}")
	ResponseEntity<?> getArtist(@PathVariable Integer artistId) {

		return ResponseEntity.ok(artistService.getArtistById(artistId));

	}

}

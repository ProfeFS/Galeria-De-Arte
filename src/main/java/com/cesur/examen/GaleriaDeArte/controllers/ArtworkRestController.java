package com.cesur.examen.GaleriaDeArte.controllers;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cesur.examen.GaleriaDeArte.domain.ArtworkDTO;
import com.cesur.examen.GaleriaDeArte.services.ArtworkService;

@RestController
@RequestMapping("/artworks")
public class ArtworkRestController {
	
	@Autowired
	ArtworkService artworkService;
	
	@PostMapping()
	public ResponseEntity<?> createArtWork(@RequestBody @Validated ArtworkDTO art){
		
		artworkService.createArtwork(art);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + art.getId())
				.buildAndExpand(art.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllArtWorks(){		
		
		return ResponseEntity.ok(artworkService.getAllArtworks()) ;
	}

}

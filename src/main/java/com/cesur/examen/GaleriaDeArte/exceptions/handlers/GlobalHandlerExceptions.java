package com.cesur.examen.GaleriaDeArte.exceptions.handlers;

import java.net.URI;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cesur.examen.GaleriaDeArte.exceptions.ArtworkCreationException;

@RestControllerAdvice
public class GlobalHandlerExceptions  {

	@ExceptionHandler(ArtworkCreationException.class )
	public ProblemDetail handleArtworkCreationException(ArtworkCreationException e) {
		
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		problemDetail.setTitle("Artwork Exception Occurred");
		problemDetail.setType(URI.create("http://cesurformacion.com"));
		problemDetail.setProperty("errorCategory", "Artwork");
		problemDetail.setProperty("timeStamp", Instant.now());

		return problemDetail;
		
		
	}

}

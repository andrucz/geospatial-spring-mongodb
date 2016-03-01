package com.andrucz.geospatial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class GeospatialSpringMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeospatialSpringMongodbApplication.class, args);
	}
}

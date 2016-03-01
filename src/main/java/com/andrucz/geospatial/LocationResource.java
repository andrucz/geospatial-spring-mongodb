package com.andrucz.geospatial;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class LocationResource {

	@Autowired
	private LocationRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<LocationEntity> getLocations(@RequestParam("lat") double latitude,
											 @RequestParam("long") double longitude,
											 @RequestParam("distance") double distance) {

		Point point = new Point(longitude, latitude);
		Distance distanceKm = new Distance(distance, Metrics.KILOMETERS);
		
		return repository.findByLocationNear(point, distanceKm);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addLocations(@RequestBody List<LocationEntry> locations) {
		
		Collection<LocationEntity> entities = locations.stream()
												.map(LocationResource::createLocationEntity)
												.collect(Collectors.toList());
		
		repository.save(entities);
		
	}
	
	private static LocationEntity createLocationEntity(LocationEntry entry) {
		return new LocationEntity(new GeoJsonPoint(entry.getLongitude(), entry.getLatitude()));
	}
	
}

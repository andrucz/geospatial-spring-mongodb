package com.andrucz.geospatial;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LocationRepository extends MongoRepository<LocationEntity, String> {

	List<LocationEntity> findByLocationNear(Point point, Distance distance);
	
}

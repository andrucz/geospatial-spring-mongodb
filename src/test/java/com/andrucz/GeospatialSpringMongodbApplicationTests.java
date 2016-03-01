package com.andrucz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.andrucz.geospatial.GeospatialSpringMongodbApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GeospatialSpringMongodbApplication.class)
@WebAppConfiguration
public class GeospatialSpringMongodbApplicationTests {

	@Test
	public void contextLoads() {
	}

}

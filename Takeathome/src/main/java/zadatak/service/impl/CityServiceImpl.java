package zadatak.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import zadatak.model.City;
import zadatak.model.ResponseWrapper;
import zadatak.model.Result;
import zadatak.service.CityService;

@Service
public class CityServiceImpl implements CityService{

	@Override
	public List<City> getAllCities() {
		List<City> cities = new ArrayList<>();

		final String url = "https://api.meetup.com/2/cities?country=rs&offset=0&format=json&photo-host=public&page=20&radius=50&order=size&desc=false&sig_id=218825650&sig=cdb228e75b7f9c364c9cf01019c4378337ca11c3";
		
		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();

		// Add the Jackson message converter
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		// Make the HTTP GET request, marshaling the response from JSON to an
		// array of Events
		List<Result> results = restTemplate.getForObject(url, ResponseWrapper.class).getResults();

		for (int i = 1; i < results.size() + 1; i++) {
			City city = new City();
			city.setId(i);
			city.setCityName(results.get(i-1).getCity());
			city.setLat(results.get(i-1).getLat());
			city.setLon(results.get(i-1).getLon());
			cities.add(city);
		}
		
		return cities;
	}
}

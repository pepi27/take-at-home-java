package zadatak.service.impl;

import java.util.List;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import zadatak.model.Event;
import zadatak.model.ResponseWrapper;
import zadatak.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Override
	public List<Event> getEventsByCity(Double lon, Double lat) {
		
		String url = ""; 
		
        url = "https://api.meetup.com/find/upcoming_events?photo-host=public&page=20&sig_id=218825650&radius=5&lon=" + lon + "&lat=" + lat + "&sig=417b62fe9d0b25822fe4cd6436e4c9eaf2d89530";
			 
		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();
		
		// Add the Jackson message converter
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		// Make the HTTP GET request, marshaling the response from JSON to an
		// array of Events
		List<Event> events = restTemplate.getForObject(url, ResponseWrapper.class).getEvents();

		return events;
	}

}

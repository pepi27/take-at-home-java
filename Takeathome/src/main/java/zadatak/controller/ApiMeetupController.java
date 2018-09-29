package zadatak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import zadatak.model.City;
import zadatak.model.Event;
import zadatak.service.impl.CityServiceImpl;
import zadatak.service.impl.EventServiceImpl;

@Controller
public class ApiMeetupController {

	@Autowired
	CityServiceImpl cityServiceImpl;
	
	@Autowired
	EventServiceImpl eventSericeImpl;

	public List<City> getAllCities() {
		return cityServiceImpl.getAllCities();
	}
	
	public List<Event> getEventsByCity(City city) {
		return eventSericeImpl.getEventsByCity(city.getLon(), city.getLat());
	}
}

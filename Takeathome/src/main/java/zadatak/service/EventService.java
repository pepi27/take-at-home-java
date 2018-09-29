package zadatak.service;

import java.util.List;

import zadatak.model.Event;

public interface EventService {

	List<Event> getEventsByCity(Double lon, Double lat);
}

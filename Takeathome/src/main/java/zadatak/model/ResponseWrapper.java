package zadatak.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "results", "events" })
public class ResponseWrapper {

	@JsonProperty("results")
	private List<Result> results = null;
	
	@JsonProperty("events")
	private List<Event> events = null;
	
	@JsonProperty("events")
	public List<Event> getEvents() {
	return events;
	}

	@JsonProperty("events")
	public void setEvents(List<Event> events) {
	this.events = events;
	}

	@JsonProperty("results")
	public List<Result> getResults() {
		return results;
	}

	@JsonProperty("results")
	public void setResults(List<Result> results) {
		this.results = results;
	}
}

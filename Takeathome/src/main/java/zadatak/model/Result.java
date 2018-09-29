package zadatak.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "lon", "city", "lat" })
public class Result {

	@JsonProperty("lon")
	private Double lon;
	@JsonProperty("city")
	private String city;
	@JsonProperty("lat")
	private Double lat;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("lon")
	public Double getLon() {
		return lon;
	}

	@JsonProperty("lon")
	public void setLon(Double lon) {
		this.lon = lon;
	}

	@JsonProperty("city")
	public String getCity() {
		return city;
	}

	@JsonProperty("city")
	public void setCity(String city) {
		this.city = city;
	}

	@JsonProperty("lat")
	public Double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(Double lat) {
		this.lat = lat;
	}
}
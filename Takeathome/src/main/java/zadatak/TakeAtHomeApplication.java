package zadatak;


import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import zadatak.controller.ApiMeetupController;
import zadatak.model.City;
import zadatak.model.Event;

@SpringBootApplication
public class TakeAtHomeApplication implements CommandLineRunner {

	@Autowired
	ApiMeetupController api;
	 
	 private static Logger log = LoggerFactory
		      .getLogger(TakeAtHomeApplication.class);
	
	public static void main(String[] args) {
		log.info("STARTING THE PROGRAM");
		new SpringApplicationBuilder(TakeAtHomeApplication.class)
        .web(WebApplicationType.NONE) // .REACTIVE, .SERVLET
        .run(args);
		log.info("PROGRAM FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		
		int menuItem = -1;

		while (menuItem != 0) {
			menuItem = menu();
			switch (menuItem) {
			case 1:
				getAllCities(api);
				break;
			case 2:
				filterEvents(api);
				break;
			case 0:
				break;
			default:
				System.out.println("Nepostojeci unos.");
				break;
			}
		}
	}
	
	private static int menu() {

		int choice;
		Scanner input = new Scanner(System.in);
		System.out.println("\n## Glavni Meni ##\n");
		System.out.println("0. Ugasiti program");
		System.out.println("1. Prikaz svih gradova");
		System.out.println("2. Prikazi dogadjaju po rednom broju grada");
		System.out.println();
		System.out.println("Unesite izbor: ");

		if (input.hasNextInt()) {
			choice = input.nextInt();

		} else {
			System.out.println("\nMorate uneti broj.");
			choice = -1;
		}

		return choice;
	}
	
	public static void getAllCities(ApiMeetupController api) {
		api.getAllCities().forEach(city -> System.out.println(city.getId() + "." + city.getCityName()));
	}
	
	private static void filterEvents(ApiMeetupController api) {
		System.out.println("\n## Filter po gradu ##");
		
		int izbor;
		Scanner input = new Scanner(System.in);
		System.out.println();
		System.out.println("Unesite redni broj grada: ");
		izbor = input.nextInt();

		if (api.getAllCities().stream().filter(x -> x.getId().equals(izbor))     
                .findAny().orElse(null) == null) {
			System.out.println("Ne postoji navedeni redni broj");
		} else {
			City city = api.getAllCities().get(izbor - 1);
			
			List<Event> events = api.getEventsByCity(city);
			
			if(!events.isEmpty()) {
				events.forEach(e -> System.out.println(city.getCityName() + "\n" + e.getName() + "\n" + ((e.getDescription() == null) ? "nema opisa" : e.getDescription()) + "\n\n"));
			} else {
				System.out.println("Trenutno nema dogadjaja u " + city.getCityName());
			}
		}
	}
}

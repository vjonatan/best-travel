package com.jv.best_travel;

import com.jv.best_travel.domain.repositories.FlyRepository;
import com.jv.best_travel.domain.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class BestTravelApplication implements CommandLineRunner {

	@Autowired
	FlyRepository  flyRepository;

	@Autowired
	HotelRepository hotelRepository;

	public static void main(String[] args) {
		SpringApplication.run(BestTravelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var fly = flyRepository.findById(15L).get();
		var hotel = hotelRepository.findById(10L).get();

		log.info(fly.toString());
		log.info(hotel.toString());
	}
}

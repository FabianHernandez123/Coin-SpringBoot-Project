package com.tts.coinCollection;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tts.coinCollection.model.Coin;
import com.tts.coinCollection.repository.CoinRepository;

@SpringBootApplication
public class CoinCollectionApplication {
	private static final Logger log = LoggerFactory.getLogger(CoinCollectionApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CoinCollectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CoinRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Coin("Small Cent", "Lincoln",2020, "MS70"));
			repository.save(new Coin("Large Cent", "Coronet Head", 1828, "VF35"));
			repository.save(new Coin("Dollar", "Peace", 1935, "AU58"));
			repository.save(new Coin("Half Dollar", "Kennedy", 1964, "AU50"));
			repository.save(new Coin("Nickel", "Jefferson", 2001, "MS61"));

			// read all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Coin coin : repository.findAll()) {
				log.info(coin.toString());
			}
			log.info("");

			// read an individual customer by ID
			repository.findById(1L)
				.ifPresent(coin -> {
					log.info("Coin found with findById(1L):");
					log.info("--------------------------------");
					log.info(coin.toString());
					log.info("");
				});

			// read customers by last name
			log.info("Coin found with findByYear(1964):");
			log.info("--------------------------------------------");
			repository.findByYear(1964).forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			log.info("");
		};
	}
	
	
	
}

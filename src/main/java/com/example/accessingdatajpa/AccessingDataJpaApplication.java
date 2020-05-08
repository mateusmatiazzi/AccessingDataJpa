package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner addSomeClientsAndFindByName(ClientList clientList) {
		return (args) -> {
			clientList.save(new Client("Jack", "Bauer"));
			clientList.save(new Client("Chloe", "O'Brian"));
			clientList.save(new Client("Kim", "Bauer"));
			clientList.save(new Client("David", "Palmer"));
			clientList.save(new Client("Michelle", "Dessler"));


			log.info("****Finding all clients:");
			log.info("-------------------------------");
			for (Client client : clientList.findAll()) {
				log.info(client.toString());
			}
			log.info("");


			Client client = clientList.findById(1L);
			log.info("****Find client with findById(1L):");
			log.info("--------------------------------");
			log.info(client.toString());
			log.info("");


			log.info("****Find client by lastName('Bauer'):");
			log.info("--------------------------------------------");
			clientList.findByLastName("Bauer").forEach(bauer -> log.info(bauer.toString()));
			log.info("");
		};
	}
}

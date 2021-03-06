package com.alae;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.alae.dao.MovieRepository;
import com.alae.entities.Movie;

@SpringBootApplication
@EnableEurekaClient
public class ServiceMoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceMoviesApplication.class, args);
	}

	
	@Bean
	CommandLineRunner start(MovieRepository movieRepository) {
		return args->{
			Stream.of("A","B","C").forEach(cn->{
				movieRepository.save(new Movie(null, cn, "alae"));
			});
			movieRepository.findAll().forEach(System.out::println);
		};
	}
}

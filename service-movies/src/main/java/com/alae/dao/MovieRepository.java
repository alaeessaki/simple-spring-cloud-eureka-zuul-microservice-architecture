package com.alae.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.alae.entities.Movie;

@RepositoryRestResource
public interface MovieRepository extends JpaRepository<Movie, Long>{

}

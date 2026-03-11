package com.spring.jpa.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.Movie;

@Repository 
public interface MovieRepo extends CrudRepository<Movie, Integer>{ 
	// T --> Type 
	//ID --> What type if 
	// not create an object but at runtime it will create proxy object with the help of jpa
	
	
	

}

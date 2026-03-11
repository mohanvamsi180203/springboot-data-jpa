package com.spring.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "Movie_Details")
public class Movie {

	@Id // to specify primary key in an entity
	@Column(name = "mid")
	private Integer movieId;
	@Column(name = "mname" , nullable = false, unique = true) // false = not null
	private String movieName;
	private String language;
	@Column(nullable = true)// true = null
	private double rating;
	private int ticketPrice;
	

}

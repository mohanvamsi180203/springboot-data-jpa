package com.spring.jpa;

import lombok.Data;
import lombok.Value;

//@Setter
//@Getter
//@NoArgsConstructor
////@AllArgsConstructor
////@RequiredArgsConstructor
//@EqualsAndHashCode  // Compare b/w Two Objects
//@ToString
@Data //Generates Getters , Setters, RequiredArgsConstuructors , EqualsAndHashCode , ToString

/*
@Value // Generates AllArgsConstructors , Getters , EqualsAndHashCode , ToString 

We don't use this because it makes object immutable i.e, need to make all the variables as final Variables

*/


public class Person {
	
	
	private int pId;
	private String name;
	//private final String email;
	

}

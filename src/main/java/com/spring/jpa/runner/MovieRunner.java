package com.spring.jpa.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.spring.jpa.SpringbootDataJpaApplication;
import com.spring.jpa.entity.Movie;
import com.spring.jpa.repo.MovieRepo;


//@Component
public class MovieRunner implements CommandLineRunner{

    private final SpringbootDataJpaApplication springbootDataJpaApplication;
	
	@Autowired
	MovieRepo mrepo;


    MovieRunner(SpringbootDataJpaApplication springbootDataJpaApplication) {
        this.springbootDataJpaApplication = springbootDataJpaApplication;
    }
	

	@Override
	public void run(String... args) throws Exception {
		Movie movie = new Movie();
		movie.setMovieId(12);
		movie.setMovieName("Premalu");
		movie.setLanguage("Telugu");
		movie.setRating(5);
		movie.setTicketPrice(100);
		mrepo.save(movie);
		
		Movie movie1 = new Movie();
		movie1.setMovieId(13);
		movie1.setMovieName("Wednesday");
		movie1.setLanguage("English");
		movie1.setRating(5);
		movie1.setTicketPrice(100);
		//mrepo.save(movie1);
		
		Movie movie2 = new Movie();
		movie2.setMovieId(14);
		movie2.setMovieName("Infinity Castle");
		movie2.setLanguage("Japanes");
		movie2.setRating(5);
		movie2.setTicketPrice(100);
		//mrepo.save(movie2);
		
		List<Movie> mList = Arrays.asList(movie1,movie2);
				//(OR)
		//Iterable<T> saveAll (Iterable <s Entity>)
		mrepo.saveAll(mList);
		
		
		//<Iterable> findAll();
		List<Movie> movies = (List<Movie>)mrepo.findAll();
		movies.forEach(System.out::println);
		
		//<Optional> findById(ID);
		Optional o =  mrepo.findById(13);  //optional is used to avoid null pointer exception
		System.out.println(o.get());
		
		
		//Iterable<T> findAllById(Itreable<ID>) 
		mrepo.findAllById(Arrays.asList(12,13,14)).forEach(System.out::println);
		
		/*
		 * If we pass existing if for the save() method
		 * it acts as update method
		 */
		
		Movie movie4 = new Movie();
		movie4.setMovieId(12);
		movie4.setMovieName("Naruto Road To Ninja");
		movie4.setRating(4);
		movie4.setLanguage("Japanese");
		movie4.setTicketPrice(100);
		mrepo.save(movie4);
		
		
		Movie movie5 = mrepo.findById(12).get() ;
		//movie5.setMovieId(12);
		//movie5.setMovieName("Naruto Road To Ninja");
		movie5.setRating(4.5);
		movie5.setLanguage("English");
		movie5.setTicketPrice(150);
		mrepo.save(movie5);
		
		System.out.println(mrepo.findById(12).get());
		
		
		
		System.out.println(mrepo.count());
		
		boolean isExist = mrepo.existsById(12);
		System.out.println(isExist);
		
		
		///deleting movie by setting id (Entity)
		Movie movie6 = new Movie();
		movie6.setMovieId(12);
		mrepo.delete(movie6);
		
		
		mrepo.deleteById(12);
		
		
		//Takes Iterable Collection as parameter
		mrepo.deleteAllById(Arrays.asList(12,13));
		
		mrepo.deleteAll(Arrays.asList(movie2));
	}
	

	
}

package com.crejo.dao;

import java.util.*;
import com.crejo.DataBase.MovieDB;
import com.crejo.model.Movie;

public class MovieDao {
	
	
	public MovieDao() {}
	
	MovieDB db = MovieDB.getInstance();
	
//	ADD MOVIE 
	public String addMovie(Movie movie) {
		
		if(db.getMovieDatabase() == null) {
			List<Movie> movieList = new ArrayList<Movie>();
			movieList.add(movie);
			db.setMovieDatabase(movieList);
		}
		db.getMovieDatabase().add(movie);
		return movie.getMovieName() + " added to Database \n";
		}
	
//	CHECKING IF MOVIE EXISTS
	public Movie isMovieExist(String movieName) {
		if (db.getMovieDatabase() == null) {
			return null;
		}
		for (int i = 0;i<db.getMovieDatabase().size();i++) {
			if (db.getMovieDatabase().get(i).getMovieName() == movieName) {
				return db.getMovieDatabase().get(i);
			}
		}
		return null;
	}
}

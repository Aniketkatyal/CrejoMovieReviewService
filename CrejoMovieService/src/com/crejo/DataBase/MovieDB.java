package com.crejo.DataBase;

import java.util.List;
import com.crejo.model.Movie;

public class MovieDB {

private static MovieDB movieDb = null;
private List<Movie> movieDatabase;

public List<Movie> getMovieDatabase() {
	return movieDatabase;
}

public void setMovieDatabase(List<Movie> movieDatabase) {
	this.movieDatabase = movieDatabase;
}

public static MovieDB getInstance() {
	if (movieDb == null) {
		movieDb = new MovieDB();
	}
	return movieDb;
}

}

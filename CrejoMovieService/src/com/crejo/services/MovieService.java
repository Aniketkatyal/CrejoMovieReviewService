package com.crejo.services;



import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.util.stream.Collectors.*;
import com.crejo.DataBase.MovieDB;
import com.crejo.DataBase.ReviewDB;
import com.crejo.DataBase.UserDB;
import com.crejo.dao.MovieDao;
import com.crejo.dao.ReviewDao;
import com.crejo.dao.UserDao;
import com.crejo.model.Movie;
import com.crejo.model.Review;
import com.crejo.model.User;

public class MovieService {
	
	MovieDao movieDao = new MovieDao();
	UserDao userDao = new UserDao();
	MovieDB movieDb = MovieDB.getInstance();
	UserDB userDb = UserDB.getInstance();
	ReviewDB reviewDb = ReviewDB.getInstance();
	
public String addMovies(String movieName, String genre, int releaseDate) {
	Movie movie = new Movie();
	System.out.println("Adding Movie ......");
	
	movie.setMovieName(movieName);
	movie.setGenre(genre);
	movie.setReleaseDate(releaseDate);
	movie.setReviewed(false);
	if (movieDao.isMovieExist(movieName) != null ) {
		return "ERROR !!!!, Movie " + movieName + " already in Database \n";
	}
	return movieDao.addMovie(movie);
}

// Top n movies by total review score by a viewer in a particular year of release.

public void topMoviesByReviewScoreByViewerByYear(int numberOfMovies, int releaseYear) {
	Map <String,Integer> movieMap = new HashMap<>();

	int totalReviewScore = 0;
	for (Movie movie: movieDb.getMovieDatabase()) {
		totalReviewScore = 0;
		if (movie.getReleaseDate() == releaseYear) {
			for (User user: userDb.getUserDatabase()) {
				if (user.getUserProfile() == "viewer") {
					
					for (Review review: reviewDb.getReviewDatabase()) {
						if (review.getUserId() == user.getUserId() && review.getMovieName() == movie.getMovieName()) {
							totalReviewScore = totalReviewScore + review.getReviewScore();
						}
					}
					
				}
			}	
		}
      movieMap.put(movie.getMovieName(), totalReviewScore);
	}
//	CREATING SORTED HASHMAP
	movieMap = movieMap
	        .entrySet()
	        .stream()
	        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));
	
	movieMap = movieMap.entrySet().stream().limit(numberOfMovies).collect(
			toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));

	System.out.println("Top " + numberOfMovies +
			" List of ratings for year " + releaseYear
			+ " and viewer profile, " + movieMap + "\n");
}


//Top n movies by total review score by a viewer in a particular GENRE.

public void topMoviesByReviewScoreByViewerByGenre(int numberOfMovies, String genre) {
	Map<String,Integer> movieMap = new HashMap<>();

	int totalReviewScore = 0;
	for (Movie movie: movieDb.getMovieDatabase()) {
		totalReviewScore = 0;
		if (movie.getGenre() == genre) {
			for (User user: userDb.getUserDatabase()) {
				if (user.getUserProfile() == "viewer") {
					
					for (Review review: reviewDb.getReviewDatabase()) {
						if (review.getUserId() == user.getUserId() && review.getMovieName() == movie.getMovieName()) {
							totalReviewScore = totalReviewScore + review.getReviewScore();
						}
					}
					
				}
			}	
		}
      movieMap.put(movie.getMovieName(), totalReviewScore);
	}
	
	movieMap = movieMap
	        .entrySet()
	        .stream()
	        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));
	
	movieMap = movieMap.entrySet().stream().limit(numberOfMovies).collect(
			toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));
	


	System.out.println("Top " + numberOfMovies 
			+ " List of ratings with genre " + genre
			+ " and viewer profile, " + movieMap + "\n");
}

//Top n movies by total review score by a CRITIC in a particular year of release.

public void topMoviesByReviewScoreByCriticByYear(int numberOfMovies, int releaseYear) {

	Map<String,Integer> movieMap = new HashMap<>();

	int totalReviewScore = 0;
	for (Movie movie: movieDb.getMovieDatabase()) {
		totalReviewScore = 0;
		if (movie.getReleaseDate() == releaseYear) {
			for (User user: userDb.getUserDatabase()) {
				if (user.getUserProfile() == "Critic") {
					
					for (Review review: reviewDb.getReviewDatabase()) {
						if (review.getUserId() == user.getUserId() && review.getMovieName() == movie.getMovieName()) {
							totalReviewScore = totalReviewScore + review.getReviewScore();
						}
					}
					
				}
			}	
		}
      movieMap.put(movie.getMovieName(), totalReviewScore);
	}
	movieMap = movieMap
	        .entrySet()
	        .stream()
	        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));
	
	movieMap = movieMap.entrySet().stream().limit(numberOfMovies).collect(
			toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));
	
	System.out.println("Top " + numberOfMovies
			+ " List of ratings by year " 
			+ releaseYear + " and Critic profile, " + movieMap + "\n");

}


//Top n movies by total review score by a CRITIC in a particular GENRE.
public void topMoviesByReviewScoreByCriticByGenre(int numberOfMovies, String genre) {
	
    Map <String,Integer> movieMap = new HashMap<>();
	int totalReviewScore = 0;
	for (Movie movie: movieDb.getMovieDatabase()) {
		totalReviewScore = 0;
		if (movie.getGenre() == genre) {
			for (User user: userDb.getUserDatabase()) {
				if (user.getUserProfile() == "Critic") {
					
					for (Review review: reviewDb.getReviewDatabase()) {
						if (review.getUserId() == user.getUserId() && review.getMovieName() == movie.getMovieName()) {
							totalReviewScore = totalReviewScore + review.getReviewScore();
						}
					}
					
				}
			}	
		}
      
      movieMap.put(movie.getMovieName(), totalReviewScore);
	}
	
	movieMap = movieMap
	        .entrySet()
	        .stream()
	        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
	        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));
	
	movieMap = movieMap.entrySet().stream().limit(numberOfMovies).collect(
			toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
	                LinkedHashMap::new));
	 
	System.out.println("Top " + numberOfMovies + " List of ratings with genre " 
					+ genre + " and Critic profile, " + movieMap + "\n");
}

// AVERAGE SCORE IN A YEAR
public String averageScoreInAYear(int releaseYear) {
	int totalScore = 0;
	int count = 0;
	for (Movie movie: movieDb.getMovieDatabase()) {
		if (movie.getReleaseDate() == releaseYear) {
			for (Review review: reviewDb.getReviewDatabase()) {
				if (review.getMovieName() == movie.getMovieName()) {
					totalScore = totalScore + review.getReviewScore();
					count = count + 1;
				}
			}
		}
	}
	return "Average Score for the Year " + releaseYear + " ::: " +(totalScore/count)  + "\n";
}

// AVERAGE SCORE FOR A GENRE
public String averageScoreForAGenre(String genre) {
	int totalScore = 0;
	int count = 0;
	for (Movie movie: movieDb.getMovieDatabase()) {
		if (movie.getGenre() == genre) {
			for (Review review: reviewDb.getReviewDatabase()) {
				if (review.getMovieName() == movie.getMovieName()) {
					totalScore = totalScore + review.getReviewScore();
					count = count + 1;
				}
			}
		}
	}
	return "Average Score for the Genre " + genre + " ::: " + (totalScore/count) + "\n";
}

// AVERAGE SCORE FOR A MOVIE
public String averageScoreForAMovie(String movieName) {
	int totalScore = 0;
	int count = 0;
	for (Movie movie: movieDb.getMovieDatabase()) {
		if (movie.getMovieName() == movieName) {
			for (Review review: reviewDb.getReviewDatabase()) {
				if (review.getMovieName() == movie.getMovieName()) {
					totalScore = totalScore + review.getReviewScore();
					count = count + 1;
				}
			}
		}
	}
	return "Average Score for the Movie " + movieName + " ::: " + (totalScore/count) + "\n";
}
	

}






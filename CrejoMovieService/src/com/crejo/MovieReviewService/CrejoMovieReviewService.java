package com.crejo.MovieReviewService;

import com.crejo.services.MovieService;
import com.crejo.services.ReviewService;
import com.crejo.services.UserService;

public class CrejoMovieReviewService {
	
	
	
	public static void main(String[] args) {
		
		
		UserService userService =  new UserService();
		MovieService movieService = new MovieService();
		ReviewService reviewService = new ReviewService();
//				ADDING USERS
				System.out.println(":::::: ADDING USERS ::::::: \n \n");
		
				System.out.println(userService.addUser("SRK"));
				System.out.println(userService.addUser("Deepika"));
				System.out.println(userService.addUser("Salman"));
				System.out.println(userService.addUser("Salman"));
				
//				ADDING MOVIES
				System.out.println(":::::: ADDING MOVIES ::::::: \n \n");
				
				System.out.println(movieService.addMovies("DON", "Action and Comedy", 2006));
				System.out.println(movieService.addMovies("Tiger", "Drama", 2008));
				System.out.println(movieService.addMovies("Padmaavat", "Comedy", 2006));
				System.out.println(movieService.addMovies("Lunchbox", "Drama", 2021));
				System.out.println(movieService.addMovies("Guru", "Drama", 2006));
				System.out.println(movieService.addMovies("Metro", "Romance", 2006));
				System.out.println(movieService.addMovies("DON", "Action and Comedy", 2006));
				
//				ADDING REVIEWS WITH INTERNAL CAPABILITIES
				System.out.println(":::::: ADDING REVIEWS ::::::: \n \n");
				
				System.out.println(reviewService.addReview("SRK", "DON", 2));
				System.out.println(reviewService.addReview("SRK", "Padmaavat", 8));
				System.out.println(reviewService.addReview("Salman", "DON", 5));
				System.out.println(reviewService.addReview("Deepika", "DON", 9));
				System.out.println(reviewService.addReview("Deepika", "Guru", 6));
				System.out.println(reviewService.addReview("SRK", "DON", 10));
				System.out.println(reviewService.addReview("Deepika", "Lunchbox", 5));
				System.out.println(reviewService.addReview("SRK", "Tiger", 5));
				System.out.println(reviewService.addReview("SRK", "Metro", 7));
				System.out.println(reviewService.addReview("SRK1", "Guru", 7));
				System.out.println(reviewService.addReview("Hritik", "Metro", 2));
				System.out.println(reviewService.addReview("Salman", "Metro", 20));
				
//				TOP N MOVIES FUNCTIONALITY	
				System.out.println(":::::: TOP N MOVIES SORT BEGINS ::::::: \n \n");
				
				movieService.topMoviesByReviewScoreByViewerByYear(2, 2006);
				movieService.topMoviesByReviewScoreByViewerByGenre(1, "Drama");
				movieService.topMoviesByReviewScoreByCriticByYear(2, 2006);
				movieService.topMoviesByReviewScoreByCriticByGenre(1, "Action and Comedy");
	
//				AVERAGE RATINGS FOR MOVIES
				System.out.println(":::::: CALCULATING AVERAGE RATINGS ::::::: \n \n");
				
				System.out.println(movieService.averageScoreInAYear(2008));
				System.out.println(movieService.averageScoreForAGenre("Romance"));
				System.out.println(movieService.averageScoreForAMovie("Tiger"));
				
				
	}
	

}

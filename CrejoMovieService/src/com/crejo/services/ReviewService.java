package com.crejo.services;

import com.crejo.dao.MovieDao;
import com.crejo.dao.ReviewDao;
import com.crejo.dao.UserDao;
import com.crejo.model.Movie;
import com.crejo.model.Review;
import com.crejo.model.User;

public class ReviewService {
	
	MovieDao movieDao = new MovieDao();
	UserDao userDao =  new UserDao();
	
	public String addReview(String userName,String movieName, int movieRating) {
		
		System.out.println("Adding Review.....");
		
		ReviewDao reviewDao = new ReviewDao();
		Review review = new Review();
		Movie movie = new Movie();
		User user = new User();
		String reviewAdded = null;

		 movie = movieDao.isMovieExist(movieName);
		 user = userDao.isUserExist(userName);


		if (movie == null) {
			return "ERROR !!!! Movie does not exist in database, please check movie Name \n";
		}
		
		if (movie.getReleaseDate() > 2020) {
			return "ERROR !!!! Movie " + movie.getMovieName() + " has not released yet, so you can't give review \n";
			}
		
		if (user == null) {
			return "ERROR !!!! User " + userName +" does not exist in database, please check user entered \n";
		}
		
		if ( !(movieRating >= 0 && movieRating <= 10) && user.getUserProfile() == "viewer") {
			return "ERROR !!!! Movie Rating must be between 0 and 10 for a viewer \n";
		}
		
		if (user.getUserProfile() == "Critic") {
			System.out.println("UPDATE :::: User " + user.getUserName() + " is a critic, Hence the rating will double");
			movieRating = movieRating * 2;
		}
		
	// check if the same movie is already reviewed by the same user
		if (reviewDao.isMovieReviewedByUser(movieName, user.getUserId())) {
			return "ERROR !!!!!! Movie " + movieName + " is already reviewed by user " + user.getUserName() + " \n";
		}
		
		else {
		
			movie.setReviewed(true);
			user.setMoviewReviewCount(user.getMoviewReviewCount() + 1);
			if (user.getMoviewReviewCount() >= 3) {
				if(user.getUserProfile() == "viewer") {
					System.out.println(("UPDATE ::::" + user.getUserName() + " is promoted to Critic"));
					user.setUserProfile("Critic");
					movieRating = movieRating * 2;
				}
				
			}
			
			review.setMovieName(movieName);
			review.setReviewScore(movieRating);
			review.setUserId(user.getUserId());
			
			reviewAdded = reviewDao.addReview(review) + " Movie:"
			+ movie.getMovieName() + ", User: " 
			+ user.getUserName() + ", Rating: " + review.getReviewScore() + " \n";
		}
		return reviewAdded;
	}
}

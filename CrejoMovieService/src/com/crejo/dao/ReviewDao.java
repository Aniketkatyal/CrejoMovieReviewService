package com.crejo.dao;

import java.util.ArrayList;
import java.util.List;

import com.crejo.DataBase.ReviewDB;
import com.crejo.model.Review;

public class ReviewDao {
	
	ReviewDB db = ReviewDB.getInstance();
	
	public ReviewDao() {}
	
//	CHECKING IF MOVIE IS REVIEWED BY THE SAME USER
	public boolean isMovieReviewedByUser(String movieName, int userId) {
	if (db.getReviewDatabase() == null) {
		return false;
	}
	for (int i=0; i< db.getReviewDatabase().size();i++) {
		if (db.getReviewDatabase().get(i).getMovieName() == movieName
				&& db.getReviewDatabase().get(i).getUserId() == userId) {
			return true;
		}
	}
	return false;
		
	}
	
//	 ADDING REVIEW
	public String addReview(Review review) {
		
		if (db.getReviewDatabase() == null) {
			List<Review> reviewList = new ArrayList<>();
			reviewList.add(review);
			db.setReviewDatabase(reviewList);
			return "review added";
		}
		db.getReviewDatabase().add(review);
		return "review added";
	}

}

package com.crejo.DataBase;

import java.util.List;
import com.crejo.model.Review;

public class ReviewDB {

	private List<Review> reviewDatabase;
	private static ReviewDB reviewDB = null;

	public List<Review> getReviewDatabase() {
		return reviewDatabase;
	}

	public void setReviewDatabase(List<Review> reviewDatabase) {
		this.reviewDatabase = reviewDatabase;
	}
	
	public static ReviewDB getInstance() {
		if (reviewDB == null) {
			reviewDB = new ReviewDB();
		}
		return reviewDB;
	}

}

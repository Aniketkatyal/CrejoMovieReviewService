package com.crejo.model;


public class User {

	private int userId;
	private String userName;
	private String userProfile; // Viewer/Critic/Expert/Admin
	private int moviewReviewCount;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	public int getMoviewReviewCount() {
		return moviewReviewCount;
	}
	public void setMoviewReviewCount(int moviewReviewCount) {
		this.moviewReviewCount = moviewReviewCount;
	}
	}

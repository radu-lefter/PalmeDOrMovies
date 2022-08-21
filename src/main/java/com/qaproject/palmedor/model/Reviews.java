package com.qaproject.palmedor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Reviews {
	
	@Id  
	@Column  
	private int reviewid;
	@Column 
	private String reviewer;
	@Column 
	private String review;
	@Column 
	private int stars;
	@Column 
	private int movieid;
		
	
	public int getReviewId() {
		return reviewid;
	}
	public void setReviewId(int reviewId) {
		this.reviewid = reviewId;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public int getMovieId() {
		return movieid;
	}
	public void setMovieId(int movieId) {
		this.movieid = movieId;
	}
	

}

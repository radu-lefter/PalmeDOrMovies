package com.qaproject.palmedor.dto;

import java.util.List;


import com.qaproject.palmedor.model.Reviews;

public class NomineesDTO {
	
 
	private int id;

	private String title;

	private String originaltitle;

	private int year;
 
	private String director;

	private String country;

	private String language;
 
	private String plot;
 
	private String wiki;
 
	private int runtimemin;
 
	private String genre;
 
	private boolean winner;
	
	//@OneToMany(mappedBy = "movieid")
	private List<Reviews> reviews;
	

	public NomineesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginaltitle() {
		return originaltitle;
	}
	public void setOriginaltitle(String originaltitle) {
		this.originaltitle = originaltitle;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getWiki() {
		return wiki;
	}
	public void setWiki(String wiki) {
		this.wiki = wiki;
	}
	public int getRuntimemin() {
		return runtimemin;
	}
	public void setRuntimemin(int runtimemin) {
		this.runtimemin = runtimemin;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public boolean isWinner() {
		return winner;
	}
	public void setWinner(boolean winner) {
		this.winner = winner;
	}
	public List<Reviews> getReviews() {
		return reviews;
	}
	
	public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	}

}

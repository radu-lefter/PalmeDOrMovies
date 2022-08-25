package com.qaproject.palmedor.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter

@Table
public class Nominees {

	

	@Id  
	@Column  
	private int id;
	@Column 
	private String title;
	@Column 
	private String originaltitle;
	@Column 
	private int year;
	@Column 
	private String director;
	@Column 
	private String country;
	@Column 
	private String language;
	@Column 
	private String plot;
	@Column 
	private String wiki;
	@Column 
	private int runtimemin;
	@Column 
	private String genre;
	@Column 
	private boolean winner;
	
	@OneToMany(mappedBy = "movieid")
	private List<Reviews> reviews;
	
	public Nominees(int id, String title, String originaltitle, int year, String director, String country,
			String language, String plot, String wiki, int runtimemin, String genre, boolean winner,
			List<Reviews> reviews) {
		//super();
		this.id = id;
		this.title = title;
		this.originaltitle = originaltitle;
		this.year = year;
		this.director = director;
		this.country = country;
		this.language = language;
		this.plot = plot;
		this.wiki = wiki;
		this.runtimemin = runtimemin;
		this.genre = genre;
		this.winner = winner;
		this.reviews = reviews;
	}

	public Nominees() {
		super();
		// TODO Auto-generated constructor stub
	}

}

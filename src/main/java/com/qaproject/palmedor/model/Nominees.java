package com.qaproject.palmedor.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	

}

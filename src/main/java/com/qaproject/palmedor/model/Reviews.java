package com.qaproject.palmedor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
		
	

}

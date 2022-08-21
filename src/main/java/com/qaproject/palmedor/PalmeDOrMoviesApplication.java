package com.qaproject.palmedor;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PalmeDOrMoviesApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(PalmeDOrMoviesApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		String sqlselect = "select * from nominees;";
		
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sqlselect);
		System.out.println(result);
		
	}

}

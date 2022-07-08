package br.com.RickAndMorty.entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Personagem {

	private int id;
	private String name;
	private String status;
	private String species;
	private String gender;
	@JsonAlias("name")
	private Origin origin;
	@JsonAlias("name")
	private Location location;
	
	public String getName() {
		return name;
	}
	

}

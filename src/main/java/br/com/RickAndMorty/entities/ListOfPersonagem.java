package br.com.RickAndMorty.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class ListOfPersonagem {

	 List<Personagem> results;
	
}

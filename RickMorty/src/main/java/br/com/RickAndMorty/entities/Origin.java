package br.com.RickAndMorty.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Origin {

	private String name;
    private String url;
    
}

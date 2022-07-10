package br.com.RickAndMorty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.RickAndMorty.entities.ListOfPersonagem;
import br.com.RickAndMorty.entities.Personagem;
import br.com.RickAndMorty.services.RickMortyService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/rickmorty")
public class RickMortyController {
	
	@Autowired
	RickMortyService rickAndMortyClient;

	@GetMapping("/personagem/")
	@ResponseStatus(HttpStatus.OK)
	public Flux<ListOfPersonagem> findPersonagem() {
		return rickAndMortyClient.findPersonagem();
	}
	
	@GetMapping("/personagem/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Personagem> findPersonagemById(@PathVariable int id) {
		return rickAndMortyClient.findPersonagemById(id);
	}
	
}

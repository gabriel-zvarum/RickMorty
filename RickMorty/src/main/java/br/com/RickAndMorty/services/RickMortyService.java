package br.com.RickAndMorty.services;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.RickAndMorty.entities.ListOfPersonagem;
import br.com.RickAndMorty.entities.Personagem;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class RickMortyService {

	private final WebClient webClient;

	public RickMortyService(WebClient.Builder builder) {
		webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
	}

	public Flux<ListOfPersonagem> findPersonagem() {
		return webClient.get().uri("/character").accept(APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToFlux(ListOfPersonagem.class);

	}

	public Mono<Personagem> findPersonagemById(int id) {
		return webClient.get().uri("/character/" + id).accept(APPLICATION_JSON).retrieve()
				.onStatus(HttpStatus::is4xxClientError,
						error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
				.bodyToMono(Personagem.class);

	}

}

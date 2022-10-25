package com.github.desafioBackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.desafioBackend.model.Videos;
import com.github.desafioBackend.repository.VideosRepository;

@RestController
@RequestMapping("/videos")
@CrossOrigin(origins = "*", allowedHeaders = "*") 
public class VideosController {

	@Autowired 
	private VideosRepository videosRepository;
	

	
	@GetMapping
	public ResponseEntity<List<Videos>> getAll (){
		return ResponseEntity.ok(videosRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Videos> getById(@PathVariable Long id) {
		return videosRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Videos>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(videosRepository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Videos> postVideos (@Valid @RequestBody Videos videos){
		
			return ResponseEntity.status(HttpStatus.CREATED).body(videosRepository.save(videos));
	
			
	}
	
	@PutMapping
	public ResponseEntity<Videos> putVideos (@Valid @RequestBody Videos videos){
		
		return videosRepository.findById(videos.getId())
				.map(resposta -> {
					return ResponseEntity.ok().body(videosRepository.save(videos));
				})
				.orElse(ResponseEntity.notFound().build());
	}
			
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteVideos(@PathVariable Long id) {
		
		return videosRepository.findById(id)
				.map(resposta -> {
					videosRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}

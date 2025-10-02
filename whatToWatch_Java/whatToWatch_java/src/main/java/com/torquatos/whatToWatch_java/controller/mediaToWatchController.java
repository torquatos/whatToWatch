package com.torquatos.whatToWatch_java.controller;

import com.torquatos.whatToWatch_java.entity.*;
import com.torquatos.whatToWatch_java.repo.*;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.*;

@RestController
@RequestMapping("/api/media")
@CrossOrigin(origins = "http://localhost:8080")

public class mediaToWatchController{
	
	@Autowired
	private mediaToWatchRepository repository;
	
	@GetMapping
	public List<mediaToWatch> getAllMedia(){
		return repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public mediaToWatch createMedia(@RequestBody mediaToWatch media) {
		return repository.save(media);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteMedia(@PathVariable Long id){
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional
	@PutMapping("/{id}/toggle-watched")
	public ResponseEntity<mediaToWatch> toggleWatched(@PathVariable Long id){
		return repository.findById(id)
				.map(media -> {
					media.setIsWatched(!media.getIsWatched());
					return ResponseEntity.ok(repository.save(media));
				})
				.orElseGet(()-> ResponseEntity.notFound().build());
	}
	
	@Transactional
	@PutMapping("/{id}/toggle-concluded")
	public ResponseEntity<mediaToWatch> toggleConcluded(@PathVariable Long id){
		return repository.findById(id)
				.map(media -> {
					media.setConcluded(!media.getConcluded());
					return ResponseEntity.ok(repository.save(media));
				})
				.orElseGet(()-> ResponseEntity.notFound().build());
	}
}
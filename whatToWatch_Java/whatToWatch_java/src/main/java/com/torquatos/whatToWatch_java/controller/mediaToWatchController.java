package com.torquatos.whatToWatch_java.controller;

import com.torquatos.whatToWatch_java.entity.*;
import com.torquatos.whatToWatch_java.repo.*;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
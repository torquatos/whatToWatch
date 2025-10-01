package com.torquatos.whatToWatch_java.controller;

import com.torquatos.whatToWatch_java.entity.*;
import com.torquatos.whatToWatch_java.repo.*;
import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
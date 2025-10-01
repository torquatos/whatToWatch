package com.torquatos.whatToWatch_java.repo;

import com.torquatos.whatToWatch_java.entity.*;
import org.springframework.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface mediaToWatchRepository extends JpaRepository<mediaToWatch, Long>{
	
}
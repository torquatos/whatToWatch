package com.torquatos.whatToWatch_java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "mediaToWatch")

public class mediaToWatch{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nameOfMedia;
	private String typeOfMedia;
	private String genre;
	private Integer year;
	private Integer seasons;
	private Boolean conclude = false;
	private String whereToWatch;
	private Boolean isWatched = false;
	
	@Lob
	private String sinopse;
	
}
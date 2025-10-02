package com.torquatos.whatToWatch_java.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import lombok.*;

@Entity
@Data
//@Getter
//@Setter
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

	public boolean getConcluded() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getIsWatched() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setConcluded(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setIsWatched(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
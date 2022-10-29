package org.iesalixar.foroGamesHelper.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="juegos")
public class Juego {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idjuego;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String compania;
	
	@Column(nullable=false)
	private String genero;
	
	@Column(nullable=false)
	private boolean coop;
	
	@OneToMany(mappedBy="juego",cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<Post> posts; 
	
}

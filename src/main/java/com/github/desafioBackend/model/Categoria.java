package com.github.desafioBackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O título da categoria é obrigatório.")
	private String titulo;
	
	@NotBlank(message = "A cor da categoria é obrigatório.")
	private String cor;

	
	//Relacionamento 
	//Uma categoria tem vários vídeos, portanto one to many
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Videos> videos;
	
	

	
	//Getters and Setters
		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

		
	//Getter e Setters do relacionamento
	
	public List<Videos> getVideos() {
		return videos;
	}

	public void setVideos(List<Videos> videos) {
		this.videos = videos;
	}
	
	
	
}

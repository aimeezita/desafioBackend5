package com.github.desafioBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="tb_videos")
public class Videos {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message= "É necessário preencher o título do vídeo")
	private String titulo;
	
	@NotBlank(message = "A descrição do vídeo é obrigatória")
	private String descricao;
	
	@NotBlank(message ="O link para o vídeo é obrigatório")
	private String url;

	
	//Relacionamento
	
	@ManyToOne
	@JsonIgnoreProperties("videos")
	private Categoria categoria;
	
	
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	
	//Get e set do Relacionamento
	public Categoria getCategoria() {
		return this.categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}

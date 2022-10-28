package com.github.desafioBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.desafioBackend.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository< Categoria, Long> {
	
	public List<Categoria> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);

	public List<Categoria> findByCorContainingIgnoreCase(@Param("cor")String cor);

}

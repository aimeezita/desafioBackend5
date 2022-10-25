package com.github.desafioBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.desafioBackend.model.Videos;

//O repositório é responsável pela comunicação com o Banco de dados através dos métodos padrão e métodos personalizados

//O JPA recebe como parâmetro a classe Videos, que tem como chave primária id do tipo Long

@Repository
public interface VideosRepository extends JpaRepository<Videos, Long> {
	
//	public Optional<Videos> findByUsuario(String videos);

    public List<Videos> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
}

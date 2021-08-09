package br.com.exemplo.eventos.repository;

import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {


    @Query(
            nativeQuery = true,
            value = "select * from autor where artigo_id_artigo"
    )
    List<Autor> autoresDeUmArtigo(@Param("idVolume") Integer idArtigo);
}

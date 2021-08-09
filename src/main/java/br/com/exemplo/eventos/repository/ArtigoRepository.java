package br.com.exemplo.eventos.repository;

import br.com.exemplo.eventos.domain.entity.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Integer> {
    @Query(
            nativeQuery = true,
            value = "select * from artigo where volume_id_volume = :idVolume"
    )
    List<Artigo> artigosDeUmVolume(@Param("idVolume") Integer idVolume);
}

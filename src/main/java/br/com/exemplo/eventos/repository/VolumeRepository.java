package br.com.exemplo.eventos.repository;

import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM artigo WHERE (:volume_id_volume IS NULL OR volume_id_volume = :idVolume)"
    )
    List<Artigo> artigosDeUmVolume(@Param("idVolume") Integer idVolume);
}

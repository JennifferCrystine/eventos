package br.com.exemplo.eventos.repository;

import br.com.exemplo.eventos.domain.entity.Volume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Integer> {


}

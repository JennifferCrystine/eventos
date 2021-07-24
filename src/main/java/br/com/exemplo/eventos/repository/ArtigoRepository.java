package br.com.exemplo.eventos.repository;

import br.com.exemplo.eventos.domain.entity.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, Integer> {
}

package br.com.exemplo.eventos.services;

import br.com.exemplo.eventos.domain.dto.AutorCreateRequest;
import br.com.exemplo.eventos.domain.dto.AutorUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Autor;
import br.com.exemplo.eventos.domain.exceptions.AutorNotFoundException;
import br.com.exemplo.eventos.repository.ArtigoRepository;
import br.com.exemplo.eventos.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private final AutorRepository repo;
    private final ArtigoRepository artigoRepository;

    @Autowired
    public AutorService(AutorRepository repo, ArtigoRepository artigoRepository){

        this.repo = repo;
        this.artigoRepository = artigoRepository;
    }

    public Optional<Autor> findById(int id){
        return repo.findById(id);
    }

    public List<Autor> findAll() {

        List<Autor> autores = repo.findAll();

        autores.sort(Comparator.comparing(autor -> autor.getPrimeiroNome()));

        return autores;
    }


    public Autor create(AutorCreateRequest autorCreateRequest) {
        var autor = new Autor();
        return criarAutor(autor, autorCreateRequest.getIdArtigo(), autorCreateRequest.getOrdemAutor(), autorCreateRequest.getEmail(), autorCreateRequest.getPrimeiroNome(), autorCreateRequest.getNomeMeio(), autorCreateRequest.getSobrenome(), autorCreateRequest.getAfiliacao(), autorCreateRequest.getAfiliacaoEn(), autorCreateRequest.getPais(), autorCreateRequest.getOrcId());
    }

    public Autor update(Integer id, AutorUpdateRequest autorUpdateRequest) throws AutorNotFoundException {
        var autorOptional = repo.findById(id);
        if(autorOptional == null) {
            throw new AutorNotFoundException();
        }
        var autor = autorOptional.get();
        return criarAutor(autor, autorUpdateRequest.getIdArtigo(), autorUpdateRequest.getOrdemAutor(), autorUpdateRequest.getEmail(), autorUpdateRequest.getPrimeiroNome(), autorUpdateRequest.getNomeMeio(), autorUpdateRequest.getSobrenome(), autorUpdateRequest.getAfiliacao(), autorUpdateRequest.getAfiliacaoEn(), autorUpdateRequest.getPais(), autorUpdateRequest.getOrcId());
    }

    private Autor criarAutor(Autor autor, Integer artigoId, int ordemAutor, String email, String primeiroNome, String nomeMeio, String sobrenome, String afiliacao, String afiliacaoEn, String pais, String orcId) {

        var artigoOptional = artigoRepository.findById(artigoId);
        var artigo = artigoOptional.get();
        autor.setArtigo(artigo);
        autor.setOrdemAutor(ordemAutor);
        autor.setEmail(email);
        autor.setPrimeiroNome(primeiroNome);
        autor.setNomeMeio(nomeMeio);
        autor.setSobrenome(sobrenome);
        autor.setAfiliacao(afiliacao);
        autor.setAfiliacaoEn(afiliacaoEn);
        autor.setPais(pais);
        autor.setOrcId(orcId);

        return repo.save(autor);
    }


    public void delete(int id){
        repo.deleteById(id);
    }
}

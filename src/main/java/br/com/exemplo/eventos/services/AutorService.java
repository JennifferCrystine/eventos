package br.com.exemplo.eventos.services;

import br.com.exemplo.eventos.domain.dto.AutorCreateRequest;
import br.com.exemplo.eventos.domain.dto.AutorUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Autor;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.domain.exceptions.AutorNotFoundException;
import br.com.exemplo.eventos.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    repository repository;
    
    @Autowired
    public AutorService(repository repo){
        repository = repo;
    }

    public Optional<Autor> findById(int id){
        return repository.findById(id);
    }

    public List<Autor> findAll() {

        List<Autor> autores = repository.findAll();

        return autores;
    }


    public Autor create(AutorCreateRequest autorCreateRequest) {
        var autor = new Autor();
        return criarAutor(autor, autorCreateRequest.getArtigo(), autorCreateRequest.getOrdemAutor(), autorCreateRequest.getEmail(), autorCreateRequest.getPrimeiroNome(), autorCreateRequest.getNomeMeio(), autorCreateRequest.getSobrenome(), autorCreateRequest.getAfiliacao(), autorCreateRequest.getAfiliacaoEn(), autorCreateRequest.getPais(), autorCreateRequest.getOrcId());
    }

    public Autor update(Integer id, AutorUpdateRequest autorUpdateRequest) throws AutorNotFoundException {
        var autorOptional = repository.findById(id);
        if(autorOptional == null) {
            throw new AutorNotFoundException();
        }
        var autor = autorOptional.get();
        return criarAutor(autor, autorUpdateRequest.getArtigo(), autorUpdateRequest.getOrdemAutor(), autorUpdateRequest.getEmail(), autorUpdateRequest.getPrimeiroNome(), autorUpdateRequest.getNomeMeio(), autorUpdateRequest.getSobrenome(), autorUpdateRequest.getAfiliacao(), autorUpdateRequest.getAfiliacaoEn(), autorUpdateRequest.getPais(), autorUpdateRequest.getOrcId());
    }

    private Autor criarAutor(Autor autor, Artigo artigo, int ordemAutor, String email, String primeiroNome, String nomeMeio, String sobrenome, String afiliacao, String afiliacaoEn, String pais, String orcId) {
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

        return repository.save(autor);
    }


    public void delete(int id){
        repository.deleteById(id);
    }
}

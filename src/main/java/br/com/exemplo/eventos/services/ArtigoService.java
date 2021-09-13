package br.com.exemplo.eventos.services;

import br.com.exemplo.eventos.domain.dto.ArtigoCreateRequest;
import br.com.exemplo.eventos.domain.dto.ArtigoUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Autor;
import br.com.exemplo.eventos.domain.exceptions.ArtigoNotFoundException;
import br.com.exemplo.eventos.repository.ArtigoRepository;
import br.com.exemplo.eventos.repository.AutorRepository;
import br.com.exemplo.eventos.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {

    ArtigoRepository repo;
    VolumeRepository volumeRepository;
    AutorRepository autorRepository;

    @Autowired
    public ArtigoService(ArtigoRepository repo, VolumeRepository volumeRepository, AutorRepository autorRepository){
        this.repo = repo;
        this.volumeRepository = volumeRepository;
        this.autorRepository = autorRepository;
    }

    public Optional<Artigo> findById(int id){
        return repo.findById(id);
    }

    public List<Artigo> findAll() {

        List<Artigo> artigos = repo.findAll();

        artigos.sort(Comparator.comparing(artigo -> artigo.getTitulo()));

        return artigos;
    }

    public Artigo create(ArtigoCreateRequest artigoCreateRequest) {
        var artigo = new Artigo();

        criarArtigo(artigo, artigoCreateRequest.getOrdemArtigo(), artigoCreateRequest.getIdioma(), artigoCreateRequest.getTitulo(), artigoCreateRequest.getTituloEn(), artigoCreateRequest.getPalavrasChaves(), artigoCreateRequest.getPalavrasChavesEn(), artigoCreateRequest.getNumeroPaginas(), artigoCreateRequest.getIdVolume(), artigoCreateRequest.getResumo(), artigoCreateRequest.getResumoEn());
        artigo.setAutores(null);

        return repo.save(artigo);
    }

    public Artigo update(Integer id, ArtigoUpdateRequest artigoUpdateRequest) throws ArtigoNotFoundException {
        var artigoOptional = repo.findById(id);
        if(artigoOptional == null) {
            throw new ArtigoNotFoundException();
        }
        var artigo = artigoOptional.get();
        criarArtigo(artigo, artigoUpdateRequest.getOrdemArtigo(), artigoUpdateRequest.getIdioma(), artigoUpdateRequest.getTitulo(), artigoUpdateRequest.getTituloEn(), artigoUpdateRequest.getPalavrasChaves(), artigoUpdateRequest.getPalavrasChavesEn(), artigoUpdateRequest.getNumeroPaginas(), artigoUpdateRequest.getIdVolume(), artigoUpdateRequest.getResumo(), artigoUpdateRequest.getResumoEn());


        return repo.save(artigo);
    }

    private void criarArtigo(Artigo artigo, int ordemArtigo, String idioma, String titulo, String tituloEn, String palavrasChaves, String palavrasChavesEn, int numeroPaginas, Integer volumeId, String resumo, String resumoEn) {
        artigo.setOrdemArtigo(ordemArtigo);
        artigo.setIdioma(idioma);
        artigo.setTitulo(titulo);
        artigo.setTituloEn(tituloEn);
        artigo.setPalavrasChaves(palavrasChaves);
        artigo.setPalavrasChavesEn(palavrasChavesEn);
        artigo.setNumeroPaginas(numeroPaginas);
        var volumeOptional = volumeRepository.findById(volumeId);
        var volume = volumeOptional.get();
        artigo.setVolume(volume);
        artigo.setResumo(resumo);
        artigo.setResumoEn(resumoEn);
    }

    public void delete(int id){
        repo.deleteById(id);
    }


    public List<Autor> artigoAutores(Integer idArtigo) {
        List<Autor> autores = autorRepository.autoresDeUmArtigo(idArtigo);

        autores.sort(Comparator.comparing(autor -> autor.getPrimeiroNome()));

        return autores;
    }
}

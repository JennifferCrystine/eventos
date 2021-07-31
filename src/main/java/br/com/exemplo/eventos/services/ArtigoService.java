package br.com.exemplo.eventos.services;

import br.com.exemplo.eventos.domain.dto.ArtigoUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.domain.exceptions.ArtigoNotFoundException;
import br.com.exemplo.eventos.repository.ArtigoRepository;
import br.com.exemplo.eventos.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {
    
    ArtigoRepository repository;
    VolumeRepository volumeRepository;
    
    @Autowired
    public ArtigoService(ArtigoRepository repo, VolumeRepository volumeRepository){
        repository = repo;
        this.volumeRepository = volumeRepository;
    }

    public Optional<Artigo> findById(int id){
        return repository.findById(id);
    }

    public List<Artigo> findAll() {

        List<Artigo> artigos = repository.findAll();

        return artigos;
    }

    public Artigo create(Artigo artigoUpdateRequest) {
        var artigo = new Artigo();

        criarArtigo(artigo, artigoUpdateRequest.getOrdemArtigo(), artigoUpdateRequest.getIdioma(), artigoUpdateRequest.getTitulo(), artigoUpdateRequest.getTituloEn(), artigoUpdateRequest.getPalavrasChaves(), artigoUpdateRequest.getPalavrasChavesEn(), artigoUpdateRequest.getNumeroPaginas(), artigoUpdateRequest.getVolume(), artigoUpdateRequest.getResumo(), artigoUpdateRequest.getResumoEn());
        artigo.setAutores(null);

        return repository.save(artigo);
    }

    public Artigo update(Integer id, ArtigoUpdateRequest artigoUpdateRequest) throws ArtigoNotFoundException {
        var artigoOptional = repository.findById(id);
        if(artigoOptional == null) {
            throw new ArtigoNotFoundException();
        }
        var artigo = artigoOptional.get();
        criarArtigo(artigo, artigoUpdateRequest.getOrdemArtigo(), artigoUpdateRequest.getIdioma(), artigoUpdateRequest.getTitulo(), artigoUpdateRequest.getTituloEn(), artigoUpdateRequest.getPalavrasChaves(), artigoUpdateRequest.getPalavrasChavesEn(), artigoUpdateRequest.getNumeroPaginas(), artigoUpdateRequest.getVolume(), artigoUpdateRequest.getResumo(), artigoUpdateRequest.getResumoEn());


        return repository.save(artigo);
    }

    private void criarArtigo(Artigo artigo, int ordemArtigo, String idioma, String titulo, String tituloEn, String palavrasChaves, String palavrasChavesEn, int numeroPaginas, Volume volume, String resumo, String resumoEn) {
        artigo.setOrdemArtigo(ordemArtigo);
        artigo.setIdioma(idioma);
        artigo.setTitulo(titulo);
        artigo.setTituloEn(tituloEn);
        artigo.setPalavrasChaves(palavrasChaves);
        artigo.setPalavrasChavesEn(palavrasChavesEn);
        artigo.setNumeroPaginas(numeroPaginas);
        artigo.setVolume(volume);
        artigo.setResumo(resumo);
        artigo.setResumoEn(resumoEn);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

}

package br.com.exemplo.eventos.services;

import br.com.exemplo.eventos.domain.dto.VolumeCreateRequest;
import br.com.exemplo.eventos.domain.dto.VolumeUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.domain.exceptions.VolumeNotFoundException;
import br.com.exemplo.eventos.repository.ArtigoRepository;
import br.com.exemplo.eventos.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VolumeService {

    VolumeRepository repo;
    ArtigoRepository artigoRepository;


    @Autowired
    public VolumeService (VolumeRepository repo, ArtigoRepository artigoRepository) {

        this.repo = repo;
        this.artigoRepository =artigoRepository;
    }

    public Optional<Volume> findById(int id){
        return repo.findById(id);
    }

    public List<Volume> findAll() {

        List<Volume> volumes = repo.findAll();

        return volumes;
    }

    public Volume create(VolumeCreateRequest volumeCreateRequest) {
        var novoVolume = new Volume();
        novoVolume.setNumeroEdicao(1);
        novoVolume.setCidade(volumeCreateRequest.getCidade());
        novoVolume.setSiglaEvento(volumeCreateRequest.getSiglaEvento());
        novoVolume.setDataInicio(volumeCreateRequest.getDataInicio());
        novoVolume.setDescricaoPt(volumeCreateRequest.getDescricaoPt());
        novoVolume.setDescricaoEn(volumeCreateRequest.getDescricaoEn());
        novoVolume.setArtigos(null);

        return repo.save(novoVolume);
    }

    public Volume update(Integer id, VolumeUpdateRequest volumeUpdateRequest) throws VolumeNotFoundException {
        var volumeOptional = repo.findById(id);
        if(volumeOptional == null) {
            throw new VolumeNotFoundException();
        }
        var volume = volumeOptional.get();
        volume.setNumeroEdicao(volumeUpdateRequest.getNumeroEdicao());
        volume.setSiglaEvento(volumeUpdateRequest.getSiglaEvento());
        volume.setCidade(volumeUpdateRequest.getCidade());
        volume.setDataInicio(volumeUpdateRequest.getDataInicio());
        volume.setDescricaoPt(volumeUpdateRequest.getDescricaoPt());
        volume.setDescricaoEn(volumeUpdateRequest.getDescricaoPt());
        var volumeArtigos = artigoRepository.artigosDeUmVolume(volume.getIdVolume());
        volume.setArtigos(volumeArtigos);

        return repo.save(volume);
    }


    public List<Artigo> volumeArtigos(Integer volumeId) {
        List<Artigo> artigos = artigoRepository.artigosDeUmVolume(volumeId);

        return artigos;
    }

    public void delete(int id){
        repo.deleteById(id);
    }
}

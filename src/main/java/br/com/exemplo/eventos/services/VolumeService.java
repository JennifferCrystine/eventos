package br.com.exemplo.eventos.services;

import br.com.exemplo.eventos.domain.dto.VolumeUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.domain.exceptions.VolumeNotFoundException;
import br.com.exemplo.eventos.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class VolumeService {
    VolumeRepository repository;


    @Autowired
    public VolumeService (VolumeRepository repo) {
        repository = repo;
    }

    public Optional<Volume> findById(int id){
        return repository.findById(id);
    }

    public List<Volume> findAll() {

        List<Volume> volumes = repository.findAll();

        return volumes;
    }

    public Volume create(Volume volumeCreateRequest) {
        var novoVolume = new Volume();
        novoVolume.setNumeroEdicao(volumeCreateRequest.getNumeroEdicao());
        novoVolume.setCidade(volumeCreateRequest.getCidade());
        novoVolume.setSiglaEvento(volumeCreateRequest.getSiglaEvento());
        novoVolume.setDataInicio(volumeCreateRequest.getDataInicio());
        novoVolume.setDescricaoPt(volumeCreateRequest.getDescricaoPt());
        novoVolume.setDescricaoEn(volumeCreateRequest.getDescricaoEn());
        novoVolume.setArtigos(null);

        return repository.save(novoVolume);
    }

    public Volume update(Integer id, VolumeUpdateRequest volumeUpdateRequest) throws VolumeNotFoundException {
        var volumeOptional = repository.findById(id);
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

        return repository.save(volume);
    }

    public void delete(int id){
       repository.deleteById(id);
    }
}

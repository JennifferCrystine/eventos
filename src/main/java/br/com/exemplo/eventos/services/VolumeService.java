package br.com.exemplo.eventos.services;

import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.repository.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class VolumeService {
    VolumeRepository repository;

    @Autowired
    public VolumeService (VolumeRepository repo) {
        repository = repo;
    }

    public Optional<Volume> FindById(int id){
        return repository.findById(id);
    }

    public Volume Create(Volume volume) {
        return repository.save(volume);
    }

    public Volume Update(Volume volume){
        return repository.save(volume);
    }

    public void Delete(int id){
       repository.deleteById(id);
    }
}

package br.com.exemplo.eventos.controllers;

import br.com.exemplo.eventos.domain.dto.ArtigoResponse;
import br.com.exemplo.eventos.domain.dto.VolumeCreateRequest;
import br.com.exemplo.eventos.domain.dto.VolumeResponse;
import br.com.exemplo.eventos.domain.dto.VolumeUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.services.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VolumeController {
    private final VolumeService service;

    @Autowired
    public VolumeController (VolumeService svc){
        service = svc;
    }

    @GetMapping("volumes/{id}")
    public ResponseEntity<VolumeResponse> getById(@PathVariable int id) {
        var volume = service.findById(id);
        var response = new VolumeResponse(volume.get());

        if (volume.isPresent()) {
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("volumes")
    public ResponseEntity<List<VolumeResponse>> getAll() {
        try {
            List<VolumeResponse> volumes = new ArrayList<>();
            service.findAll().forEach(v -> volumes.add(new VolumeResponse(v)));

            if (volumes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return ResponseEntity.ok(volumes);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("volumes")
    public ResponseEntity<VolumeResponse> create(@RequestBody VolumeCreateRequest volumeCreateRequest) {
        try {
            var response = new VolumeResponse(service.create(volumeCreateRequest));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("volumes/{id}")
    public ResponseEntity<VolumeResponse> update(@RequestBody VolumeUpdateRequest volume, @PathVariable Integer id) {
        try {
            var response = new VolumeResponse(service.update(id, volume));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("volumes/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("volumes/{idVolume}/artigos")
    public ResponseEntity<List<ArtigoResponse>> getAllVolumeArticles(@PathVariable Integer idVolume) {

        try {
            List<Artigo> artigos = service.volumeArtigos(idVolume);
            List<ArtigoResponse> response = new ArrayList<>();

            artigos.forEach(a -> response.add(new ArtigoResponse(a)));

            if (response.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package br.com.exemplo.eventos.controllers;

import br.com.exemplo.eventos.domain.dto.VolumeCreateRequest;
import br.com.exemplo.eventos.domain.dto.VolumeUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.services.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VolumeController {
    private final VolumeService service;

    @Autowired
    public VolumeController (VolumeService svc){
        service = svc;
    }

    @GetMapping("volumes/{id}")
    public ResponseEntity<Volume> getVolumeById(@PathVariable("id") int id) {
        Optional<Volume> volume = service.findById(id);

        if (volume.isPresent()) {
            return new ResponseEntity<Volume>(volume.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("volumes")
    public ResponseEntity<List<Volume>> getAllVolumes() {
        try {
            List<Volume> volumes = service.findAll();

            if (volumes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(volumes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("volumes")
    public ResponseEntity<Volume> createVolume(@RequestBody VolumeCreateRequest volumeCreateRequest) {
        try {
            return new ResponseEntity<>(service.create(volumeCreateRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("volumes/{id}")
    public ResponseEntity<Volume> updateVolume(@RequestBody VolumeUpdateRequest volume, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.update(id, volume), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("volumes/{id}")
    public ResponseEntity<HttpStatus> deleteVolume(@RequestBody Volume volume) {
        try {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package br.com.exemplo.eventos.controllers;

import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.services.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VolumeController {
    private VolumeService service;

    @Autowired
    public VolumeController (VolumeService svc){
        service = svc;
    }

    @GetMapping("/volume/{id}")
    public ResponseEntity<Volume> getVolumeById(@PathVariable("id") int id) {
        Optional<Volume> volume = service.FindById(id);

        if (volume.isPresent()) {
            return new ResponseEntity<Volume>(volume.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/volume")
    public ResponseEntity<Volume> createVolume(@RequestBody Volume volume) {
        try {
            return new ResponseEntity<>(service.Create(volume), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/volume/{id}")
    public ResponseEntity<Volume> updateVolume(@RequestBody Volume volume) {
        try {
            return new ResponseEntity<>(service.Update(volume), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/volume/{id}")
    public ResponseEntity<HttpStatus> deleteVolume(@RequestBody Volume volume) {
        try {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

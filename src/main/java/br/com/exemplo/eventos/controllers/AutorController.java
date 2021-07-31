package br.com.exemplo.eventos.controllers;

import br.com.exemplo.eventos.domain.dto.AutorCreateRequest;
import br.com.exemplo.eventos.domain.dto.AutorUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Autor;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AutorController {

    AutorService service;

    @Autowired
    public AutorController(AutorService service){
        this.service = service;
    }

    @GetMapping("api/autor/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable("id") int id) {
        Optional<Autor> Autor = service.findById(id);

        if (Autor.isPresent()) {
            return new ResponseEntity<Autor>(Autor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("api/autores")
    public ResponseEntity<List<Autor>> getAllVolumes() {
        try {
            List<Autor> autores = service.findAll();

            if (autores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(autores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("api/autor")
    public ResponseEntity<Autor> createAutor(@RequestBody AutorCreateRequest autorCreateRequest) {
        try {
            return new ResponseEntity<>(service.create(autorCreateRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("api/autor/{id}")
    public ResponseEntity<Autor> updateAutor(@RequestBody AutorUpdateRequest autorUpdateRequest, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.update(id, autorUpdateRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("api/autor/{id}")
    public ResponseEntity<HttpStatus> deleteAutor(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

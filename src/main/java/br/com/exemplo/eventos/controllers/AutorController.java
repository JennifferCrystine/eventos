package br.com.exemplo.eventos.controllers;

import br.com.exemplo.eventos.domain.dto.AutorCreateRequest;
import br.com.exemplo.eventos.domain.dto.AutorResponse;
import br.com.exemplo.eventos.domain.dto.AutorUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Autor;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AutorController {

    AutorService service;

    @Autowired
    public AutorController(AutorService service){
        this.service = service;
    }

    @GetMapping("autores/{id}")
    public ResponseEntity<AutorResponse> getAutorById(@PathVariable("id") int id) {
        AutorResponse response = new AutorResponse(service.findById(id).get());

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("autores")
    public ResponseEntity<List<AutorResponse>> getAll() {
        try {
            List<AutorResponse> autores = new ArrayList<>();
            service.findAll().forEach(a -> autores.add(new AutorResponse(a)));

            if (autores.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(autores, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("autores")
    public ResponseEntity<AutorResponse> create(@RequestBody AutorCreateRequest autorCreateRequest) {
        try {
            if(autorCreateRequest == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            AutorResponse response = new AutorResponse(service.create(autorCreateRequest));
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("autores/{id}")
    public ResponseEntity<AutorResponse> update(@RequestBody AutorUpdateRequest autorUpdateRequest, @PathVariable Integer id) {
        try {
            if(autorUpdateRequest == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            var response = new AutorResponse(service.update(id, autorUpdateRequest));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("autores/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

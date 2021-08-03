package br.com.exemplo.eventos.controllers;

import br.com.exemplo.eventos.domain.dto.ArtigoCreateRequest;
import br.com.exemplo.eventos.domain.dto.ArtigoUpdateRequest;
import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Volume;
import br.com.exemplo.eventos.services.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ArtigoController {

    ArtigoService service;

    @Autowired
    public ArtigoController(ArtigoService service){
        this.service = service;
    }

    @GetMapping("artigos/{id}")
    public ResponseEntity<Artigo> getArtigoById(@PathVariable("id") int id) {
        Optional<Artigo> artigo = service.findById(id);

        if (artigo.isPresent()) {
            return new ResponseEntity<Artigo>(artigo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/artigos")
    public ResponseEntity<List<Artigo>> getAllArtigos() {
        try {
            List<Artigo> artigos = service.findAll();

            if (artigos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(artigos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/artigos")
    public ResponseEntity<Artigo> createArtigo(@RequestBody ArtigoCreateRequest artigoCreateRequest) {
        try {
            return new ResponseEntity<>(service.create(artigoCreateRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("artigos/{id}")
    public ResponseEntity<Artigo> updateArtigo(@RequestBody ArtigoUpdateRequest artigoUpdateRequest, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.update(id, artigoUpdateRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("artigos/{id}")
    public ResponseEntity<HttpStatus> deleteArtigo(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

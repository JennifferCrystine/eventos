package br.com.exemplo.eventos.controllers;

import br.com.exemplo.eventos.domain.dto.ArtigoCreateRequest;
import br.com.exemplo.eventos.domain.dto.ArtigoResponse;
import br.com.exemplo.eventos.domain.dto.ArtigoUpdateRequest;
import br.com.exemplo.eventos.domain.dto.AutorResponse;
import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Autor;
import br.com.exemplo.eventos.services.ArtigoService;
import br.com.exemplo.eventos.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<ArtigoResponse> getById(@PathVariable("id") int id) {
        Optional<Artigo> artigo = service.findById(id);
        var response = new ArtigoResponse(artigo.get());

        if (artigo.isPresent()) {
            return ResponseEntity.ok(response);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/artigos")
    public ResponseEntity<List<ArtigoResponse>> getAll() {
        try {
            List<ArtigoResponse> artigos = new ArrayList<ArtigoResponse>();
            service.findAll().forEach(a -> artigos.add(new ArtigoResponse(a)));

            if (artigos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(artigos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/artigos")
    public ResponseEntity<ArtigoResponse> create(@RequestBody ArtigoCreateRequest artigoCreateRequest) {
        try {
            var artigo = service.create(artigoCreateRequest);
            if (artigo == null) return new ResponseEntity<>(HttpStatus.CONFLICT);

            ArtigoResponse response = new ArtigoResponse(artigo);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("artigos/{id}")
    public ResponseEntity<ArtigoResponse> update(@RequestBody ArtigoUpdateRequest artigoUpdateRequest, @PathVariable Integer id) {
        try {
            ArtigoResponse response = new ArtigoResponse(service.update(id, artigoUpdateRequest));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("artigos/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("artigos/{idArtigo}/autores")
    public ResponseEntity<List<AutorResponse>> getAllArticleAutors(@PathVariable Integer idArtigo) {

        try {
            List<Autor> autores = service.artigoAutores(idArtigo);
            List<AutorResponse> response = new ArrayList<>();

            autores.forEach(a -> response.add(new AutorResponse(a)));

            if (response.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

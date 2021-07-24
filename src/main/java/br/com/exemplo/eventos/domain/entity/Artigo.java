package br.com.exemplo.eventos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "artigo")
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_artigo;

    @ManyToOne
    private Volume volume;

    @OneToMany(mappedBy = "artigo")
    @OrderBy("primeiro_nome asc")
    private List<Autor> autores;

    private int ordem_artigo;

    private String idioma;

    private String titulo;

    private String titulo_en;

    private String resumo;

    private String resumo_en;

    private String palavras_chaves;

    private String palavras_chaves_en;

    private int numero_paginas;
}

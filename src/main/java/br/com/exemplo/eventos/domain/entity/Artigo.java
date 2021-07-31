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
    private int idArtigo;

    @ManyToOne
    private Volume volume;

    @OneToMany(mappedBy = "artigo")
    @OrderBy("primeiro_nome asc")
    private List<Autor> autores;

    private int ordemArtigo;

    private String idioma;

    private String titulo;

    private String tituloEn;

    private String resumo;

    private String resumoEn;

    private String palavrasChaves;

    private String palavrasChavesEn;

    private int numeroPaginas;
}

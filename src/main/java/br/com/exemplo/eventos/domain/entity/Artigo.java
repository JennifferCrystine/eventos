package br.com.exemplo.eventos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity()
@NoArgsConstructor
@AllArgsConstructor
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdArtigo;
    private Volume NumVolume;
    private int OrdemArtigo;
    private String Idioma;
    private String Titulo;
    private String TituloEN;
    private String Resumo;
    private String ResumoEN;
    private String PalavrasChaves;
    private String PalavrasChavesEN;
    private int NumeroDePaginas;
    private List<Autor> Autores;
}

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
    private int IdArtigo;
    @ManyToOne
    private Volume NumVolume;
    @OneToMany
    @OrderBy("PrimeiroNome asc")
    private List<Autor> Autores;
    private int OrdemArtigo;
    private String Idioma;
    private String Titulo;
    private String TituloEN;
    private String Resumo;
    private String ResumoEN;
    private String PalavrasChaves;
    private String PalavrasChavesEN;
    private int NumeroDePaginas;
}

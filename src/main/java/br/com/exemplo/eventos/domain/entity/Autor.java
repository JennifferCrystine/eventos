package br.com.exemplo.eventos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdAutor;
    @OneToOne
    private Artigo Artigo;
    private int OrdemAutor;
    private String Email;
    private String PrimeiroNome;
    private String NomeDoMeio;
    private String Sobrenome;
    private String Afiliacao;
    private String AfiliacaoEN;
    private String Pais;
    private String OrcID;
    private int NumeroDePaginas;
}

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
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdAutor;
    private int OrdemAutor;
    private String Email;
    private String PrimeiroNome;
    private String NomeDoMeio;
    private String Sobrenome;
    private String Filiacao;
    private String FiliacaoEN;
    private String Pais;
    private String OrcID;
    private Artigo NumeroDePaginas;
}

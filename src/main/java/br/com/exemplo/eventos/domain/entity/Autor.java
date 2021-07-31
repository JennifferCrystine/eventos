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
    private int idAutor;

    @ManyToOne
    private Artigo artigo;

    private int ordemAutor;

    private String email;

    private String primeiroNome;

    private String nomeMeio;

    private String sobrenome;

    private String afiliacao;

    private String afiliacaoEn;

    private String pais;

    private String orcId;
}

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
    private int id_autor;

    @ManyToOne
    private Artigo artigo;

    private int ordem_autor;

    private String email;

    private String primeiro_nome;

    private String nome_meio;

    private String sobrenome;

    private String afiliacao;

    private String afiliacao_en;

    private String pais;

    private String orc_id;
}

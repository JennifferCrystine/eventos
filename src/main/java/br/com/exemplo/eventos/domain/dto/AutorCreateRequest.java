package br.com.exemplo.eventos.domain.dto;

import br.com.exemplo.eventos.domain.entity.Artigo;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class AutorCreateRequest {

    private Integer idArtigo;

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

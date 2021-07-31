package br.com.exemplo.eventos.domain.dto;

import br.com.exemplo.eventos.domain.entity.Artigo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VolumeUpdateRequest {

    private Integer numeroEdicao;

    private String siglaEvento;

    private String cidade;

    private Date dataInicio;

    private String descricaoPt;

    private String descricaoEn;

    private List<Artigo> artigos;
}

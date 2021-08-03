package br.com.exemplo.eventos.domain.dto;

import lombok.Data;

import java.util.Date;

@Data
public class VolumeUpdateRequest {

    private Integer numeroEdicao;

    private String siglaEvento;

    private String cidade;

    private Date dataInicio;

    private String descricaoPt;

    private String descricaoEn;
}

package br.com.exemplo.eventos.domain.dto;

import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Volume;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VolumeResponse {

    private Integer idVolume;

    private Integer numeroEdicao;

    private String siglaEvento;

    private String cidade;

    private Date dataInicio;

    private String descricaoPt;

    private String descricaoEn;

    private List<Artigo> artigos;

    public VolumeResponse(Volume volume) {
        this.idVolume = volume.getIdVolume();
        this.numeroEdicao = volume.getNumeroEdicao();
        this.siglaEvento = volume.getSiglaEvento();
        this.cidade = volume.getCidade();
        this.dataInicio = volume.getDataInicio();
        this.descricaoPt = volume.getDescricaoPt();
        this.descricaoEn = volume.getDescricaoEn();
        this.artigos = null;
    }
}

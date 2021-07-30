package br.com.exemplo.eventos.domain.dto;

import br.com.exemplo.eventos.domain.entity.Artigo;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class VolumeCreateRequest {

    private Integer numero_edicao;

    private String sigla_evento;

    private String cidade;

    private Date data_inicio;

    private String descricao_pt;

    private String descricao_en;

    private List<Artigo> artigos;
}

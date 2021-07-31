package br.com.exemplo.eventos.domain.dto;

import br.com.exemplo.eventos.domain.entity.Volume;
import lombok.Data;

@Data
public class ArtigoUpdateRequest {
    private Volume volume;

    private int ordemArtigo;

    private String idioma;

    private String titulo;

    private String tituloEn;

    private String resumo;

    private String resumoEn;

    private String palavrasChaves;

    private String palavrasChavesEn;

    private int numeroPaginas;
}

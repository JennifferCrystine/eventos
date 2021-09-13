package br.com.exemplo.eventos.domain.dto;


import lombok.Data;


@Data
public class ArtigoCreateRequest {

    private Integer idVolume;

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

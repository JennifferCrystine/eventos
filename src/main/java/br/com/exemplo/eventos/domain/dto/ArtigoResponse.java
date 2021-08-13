package br.com.exemplo.eventos.domain.dto;

import br.com.exemplo.eventos.domain.entity.Artigo;
import br.com.exemplo.eventos.domain.entity.Autor;
import lombok.Data;

import java.util.List;


@Data
public class ArtigoResponse {

    private Integer idArtigo;

    private Integer idVolume;

    private List<Autor> autores;

    private int ordemArtigo;

    private String idioma;

    private String titulo;

    private String tituloEn;

    private String resumo;

    private String resumoEn;

    private String palavrasChaves;

    private String palavrasChavesEn;

    private int numeroPaginas;

    public ArtigoResponse(Artigo artigo){
        this.autores = null;
        this.idVolume = artigo.getVolume().getIdVolume();
        this.idArtigo = artigo.getIdArtigo();
        this.ordemArtigo = artigo.getOrdemArtigo();
        this.idioma = artigo.getIdioma();
        this.titulo = artigo.getTitulo();
        this.tituloEn = artigo.getTituloEn();
        this.resumo = artigo.getResumo();
        this.resumoEn = artigo.getResumoEn();
        this.palavrasChaves = artigo.getPalavrasChaves();
        this.palavrasChavesEn = artigo.getPalavrasChavesEn();
        this.numeroPaginas = artigo.getNumeroPaginas();
    }


}

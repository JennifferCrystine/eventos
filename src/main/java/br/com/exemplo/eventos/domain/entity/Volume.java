package br.com.exemplo.eventos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "volume")
public class Volume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idVolume;

    private Integer numeroEdicao;

    private String siglaEvento;

    private String cidade;

    private Date dataInicio;

    private String descricaoPt;

    private String descricaoEn;

    @OrderBy("titulo asc")
    @OneToMany(mappedBy = "volume")
    private List<Artigo> artigos;
}

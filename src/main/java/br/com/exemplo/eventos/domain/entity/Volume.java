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
    private int IdVolume;
    private int NumeroEdicao;
    private String SiglaEvento;
    private String Cidade;
    private Date DataInicio;
    private String DescricaoPT;
    private String DescricaoEN;
    @OneToMany
    @OrderBy("Titulo asc")
    private List<Artigo> Artigos;
}

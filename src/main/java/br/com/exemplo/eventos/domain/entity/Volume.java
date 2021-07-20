package br.com.exemplo.eventos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Data
@Entity()
@NoArgsConstructor
@AllArgsConstructor
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
    private List<Artigo> Artigos;
}

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
    private Integer id_volume;

    private Integer numero_edicao;

    private String sigla_evento;

    private String cidade;

    private Date data_inicio;

    private String descricao_pt;

    private String descricao_en;

    @OrderBy("titulo asc")
    @OneToMany(mappedBy = "volume")
    private List<Artigo> artigos;
}

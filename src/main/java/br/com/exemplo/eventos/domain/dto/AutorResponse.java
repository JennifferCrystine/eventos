package br.com.exemplo.eventos.domain.dto;
import br.com.exemplo.eventos.domain.entity.Autor;
import lombok.Data;

@Data
public class AutorResponse {

    private int idAutor;

    private Integer idArtigo;

    private int ordemAutor;

    private String email;

    private String primeiroNome;

    private String nomeMeio;

    private String sobrenome;

    private String afiliacao;

    private String afiliacaoEn;

    private String pais;

    private String orcId;

    public AutorResponse(Autor autor) {
        this.idAutor = autor.getIdAutor();
        this.idArtigo = autor.getArtigo().getIdArtigo();
        this.ordemAutor = autor.getOrdemAutor();
        this.email = autor.getEmail();
        this.primeiroNome = autor.getPrimeiroNome();
        this.nomeMeio = autor.getNomeMeio();
        this.sobrenome = autor.getSobrenome();
        this.afiliacao = autor.getAfiliacao();
        this.afiliacaoEn = autor.getAfiliacaoEn();
        this.pais = autor.getPais();
        this.orcId = autor.getOrcId();

    }
}

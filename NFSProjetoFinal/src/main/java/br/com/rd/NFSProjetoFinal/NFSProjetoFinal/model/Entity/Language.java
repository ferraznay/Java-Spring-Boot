package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.embeddable.LanguageKey;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;


@Entity
@Data
public class Language {
@EmbeddedId
    private LanguageKey languageKey;

    @Column(nullable = false)
    private LocalDate last_update;



}

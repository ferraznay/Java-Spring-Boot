package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.embeddable;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class LanguageKey implements Serializable {
    @Column
    private String country;
    @Column
    private String name;


}

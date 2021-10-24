package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO;

import lombok.Data;

import java.time.LocalDate;


@Data
public class LanguageDTO {
    private LanguageKeyDTO languageKey;
    private LocalDate last_update;
}

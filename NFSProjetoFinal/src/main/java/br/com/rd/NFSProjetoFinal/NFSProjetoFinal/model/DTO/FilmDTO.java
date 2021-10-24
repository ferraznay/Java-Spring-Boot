package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO;

import lombok.Data;

import java.time.LocalDate;


@Data
public class FilmDTO {
    private Long id;
    private String title;
    private String description;
    private Long release_year;
    private Double rental_rate;
    private LanguageKeyDTO languageKey;
    private LocalDate last_update;
    private CategoryDTO category;



}

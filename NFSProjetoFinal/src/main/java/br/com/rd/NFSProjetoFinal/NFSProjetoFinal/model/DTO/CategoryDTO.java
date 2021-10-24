package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO;

import lombok.Data;

import java.time.LocalDate;


@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private LocalDate last_update;
}

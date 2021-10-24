package br.com.rd.NFSProjetoCrudTaskManager.model.TaskDTO;


import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class TaskDTO {
    private Long id;
    private String descricao;
    private Boolean feito;
    private LocalDate dataDeAtualizacao;
    private Double porcetagemConclusao;
}

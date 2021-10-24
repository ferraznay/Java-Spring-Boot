package br.com.rd.NFSProjetoCrudTaskManager.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class TaskManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Boolean feito;
    @Column(nullable = false)
    private LocalDate dataDeAtualizacao;
    @Column(nullable = false)
    private Double porcetagemConclusao;



}

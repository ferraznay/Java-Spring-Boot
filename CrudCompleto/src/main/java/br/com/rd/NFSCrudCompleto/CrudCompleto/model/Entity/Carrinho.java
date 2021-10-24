package br.com.rd.NFSCrudCompleto.CrudCompleto.model.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String usuario;
}

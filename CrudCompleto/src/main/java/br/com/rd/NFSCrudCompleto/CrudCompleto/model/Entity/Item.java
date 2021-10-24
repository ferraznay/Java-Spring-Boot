package br.com.rd.NFSCrudCompleto.CrudCompleto.model.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String descricao;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cl_carrinho")
    private Carrinho carCarrinho;
}

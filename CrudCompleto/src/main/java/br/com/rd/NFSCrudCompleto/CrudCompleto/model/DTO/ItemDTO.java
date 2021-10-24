package br.com.rd.NFSCrudCompleto.CrudCompleto.model.DTO;

import lombok.Data;

@Data
public class ItemDTO {
    private Long id;
    private String descricao;
    private CarrinhoDTO carrinho;
}

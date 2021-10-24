package br.com.rd.NFSCrudCompleto.CrudCompleto.repository.contract;

import br.com.rd.NFSCrudCompleto.CrudCompleto.model.Entity.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}

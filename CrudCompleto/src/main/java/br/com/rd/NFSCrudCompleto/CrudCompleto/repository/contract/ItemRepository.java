package br.com.rd.NFSCrudCompleto.CrudCompleto.repository.contract;

import br.com.rd.NFSCrudCompleto.CrudCompleto.model.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}

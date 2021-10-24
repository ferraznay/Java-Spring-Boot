package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

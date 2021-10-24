package br.com.rd.NFSProjetoServico.repository.contract;

import br.com.rd.NFSProjetoServico.model.Entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarroRepository extends JpaRepository <Carro, Long> {


}

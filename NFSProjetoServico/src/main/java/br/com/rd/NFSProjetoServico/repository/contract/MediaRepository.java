package br.com.rd.NFSProjetoServico.repository.contract;

import br.com.rd.NFSProjetoServico.model.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {


}

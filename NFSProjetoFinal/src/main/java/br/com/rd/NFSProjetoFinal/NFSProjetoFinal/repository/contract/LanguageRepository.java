package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Language;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.embeddable.LanguageKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, LanguageKey> {

    List<Language> findByLanguageKeyCountry(String country);


}

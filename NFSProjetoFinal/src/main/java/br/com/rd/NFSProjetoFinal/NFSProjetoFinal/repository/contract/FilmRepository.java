package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>, FilmRepositoryCustom {
    @Query(value = " SELECT * FROM FILM F WHERE F.TITLE LIKE %:busca% ", nativeQuery = true)
    List<Film> buscaTitle(
            @Param("busca") String busca);

    List<Film> findByDescriptionContaining(String description);


}

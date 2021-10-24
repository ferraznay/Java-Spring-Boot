package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.implementation;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Film;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract.FilmRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class FilmRepositoryImpl implements FilmRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Film> release (Long release_year){

        Query sql = entityManager.createNativeQuery("SELECT * FROM FILM WHERE RELEASE_YEAR = ?" , Film.class);
        sql.setParameter(1, release_year );

        List<Film> list = sql.getResultList();
        return list;
    }

}

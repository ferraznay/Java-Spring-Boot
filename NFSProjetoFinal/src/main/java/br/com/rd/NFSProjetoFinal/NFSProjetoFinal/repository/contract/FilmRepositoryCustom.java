package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Film;

import java.util.List;

public interface FilmRepositoryCustom {

 List<Film> release (Long release_year);

}

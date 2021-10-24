package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.controller;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.CategoryDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.FilmDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.service.CategoryService;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    FilmService filmService;

    @PostMapping

    public FilmDTO create(@RequestBody FilmDTO film){

        return filmService.addFilm(film);
    }


    @GetMapping
    public List<FilmDTO> findAll(){

        return filmService.findAllFilm();
    }

    @GetMapping ("/{id}")
    public FilmDTO searchFilmById(@PathVariable ("id") Long id){

        return filmService.searchFilmById(id);
    }

    @PutMapping("/{id}")
    public FilmDTO updateByFilmId(@RequestBody FilmDTO dto, @PathVariable("id") Long id){
        return filmService.updateByFilmId(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByFilmId(@PathVariable("id") Long id){
        filmService.deleteByFilmId(id);
    }

    @GetMapping("/por-title/{busca}")
    public List<FilmDTO> findByTitleLike(@PathVariable("busca") String busca){
        return filmService.buscaTitle(busca);
    }
    @GetMapping("/por-release/{release_year}")
    public List<FilmDTO> findByYearLike(@PathVariable("release_year") Long release_year){
        return filmService.buscaRelease(release_year);
    }

    @GetMapping("por-description/{description}")
    public List<FilmDTO> buscaDescription(@PathVariable("description") String description){
        return filmService.buscaDescription(description);
    }

}


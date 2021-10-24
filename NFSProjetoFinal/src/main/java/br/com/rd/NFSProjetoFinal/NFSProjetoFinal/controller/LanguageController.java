package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.controller;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.LanguageDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    LanguageService languageService;

    @PostMapping
    public LanguageDTO create(@RequestBody LanguageDTO language){
        try {
            return languageService.add(language);
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping
    public List<LanguageDTO> findAll(){
        return languageService.findAll();
    }

    @GetMapping("/{country}/{name}")
    public LanguageDTO searchCountryName(@PathVariable("country") String country, @PathVariable("name") String name){
        return languageService.searchCountryName(country, name);
    }

    @GetMapping("/{id}")
    public List<LanguageDTO> searchAllByCountry(@PathVariable("country") String country){
        return languageService.searchAllByCountry(country);
    }
}

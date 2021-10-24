package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.service;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.CategoryDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.FilmDTO;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.LanguageDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.LanguageKeyDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Category;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Film;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Language;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.embeddable.LanguageKey;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract.CategoryRepository;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract.FilmRepository;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    LanguageRepository languageRepository;

    public FilmDTO addFilm(FilmDTO film) {
        Film newFilm = this.dtoToBusiness(film);

        Long id = newFilm.getCatCategory().getId();
        if (id != null) {
            Category c = this.categoryRepository.getById(id);
            newFilm.setCatCategory(c);
        }

        newFilm = filmRepository.save(newFilm);
        return this.businessToDto(newFilm);
    }


    public List<FilmDTO> findAllFilm(){
        List<Film> allList = filmRepository.findAll();
        return this.listToFilmDto(allList);
    }

    public List<FilmDTO> listToFilmDto(List<Film> list){
        List<FilmDTO> listFilmDto = new ArrayList<FilmDTO>();
        for (Film f : list){
            listFilmDto.add(this.businessToDto(f));
        }
        return listFilmDto;
    }

    public FilmDTO searchFilmById(Long id){
        Optional<Film> op = filmRepository.findById(id);

        if(op.isPresent()){
            return businessToDto(op.get());
        }
        return null;
    }


    public FilmDTO updateByFilmId(FilmDTO dto, Long id){
        Optional<Film> op = filmRepository.findById(id);

        if (op.isPresent()){
            Film obj = op.get();
            if (dto.getTitle() != null){
                obj.setTitle(dto.getTitle());
            }
            if (dto.getDescription() != null){
                obj.setDescription(dto.getDescription());
            }
            if (dto.getRelease_year() != null){
                obj.setRelease_year(dto.getRelease_year());
            }
            if (dto.getRental_rate() != null){
                obj.setRental_rate(dto.getRental_rate());
            }
            if (dto.getLast_update() != null){
                obj.setLast_update(dto.getLast_update());
            }
            if(dto.getCategory() != null){
                Category category = new Category();
                if (dto.getCategory().getId() != null){
                    category.setId(dto.getCategory().getId());
                    if (categoryRepository.existsById(obj.getCatCategory().getId())){
                        obj.setCatCategory(categoryRepository.getById(dto.getCategory().getId()));
                    } else {
                        category.setName(dto.getCategory().getName());
                        category.setLast_update(dto.getCategory().getLast_update());
                        obj.setCatCategory(category);
                        categoryRepository.save(obj.getCatCategory());
                    }
                }
            }

      
            filmRepository.save(obj);
            return businessToDto(obj);
        }
        return null;
    }

    public void deleteByFilmId(Long id){
        if(filmRepository.existsById(id)){
            filmRepository.deleteById(id);
        }
    }

    public List<FilmDTO> buscaTitle(String title){
        List<Film> filmList = filmRepository.buscaTitle(title);
        return listToFilmDto(filmList);
    }
    public List<FilmDTO> buscaRelease(Long release_year){
        List<Film> list = filmRepository.release(release_year);
        return listToFilmDto(list);
    }

    public List<FilmDTO> buscaDescription(String description){
        List<Film> list = filmRepository.findByDescriptionContaining(description);
        return listToFilmDto(list);
    }

    public Film dtoToBusiness(FilmDTO dto){
        Film business = new Film();
        business.setTitle(dto.getTitle());
        business.setDescription(dto.getDescription());
        business.setRelease_year(dto.getRelease_year());
        business.setRental_rate(dto.getRental_rate());
        business.setLast_update(dto.getLast_update());
        if (dto.getCategory() != null){
            Category c =  new Category();
            if (dto.getCategory().getId() != null){
                c.setId(dto.getCategory().getId());
            }else{
                c.setName(dto.getCategory().getName());
                c.setLast_update(dto.getCategory().getLast_update());
            }
            business.setCatCategory(c);
        }

        if(dto.getLanguageKey() != null){
            Language lBusiness = new Language();
            LanguageKey lKey = new LanguageKey();

            lKey.setCountry(dto.getLanguageKey().getCountry());
            lKey.setName(dto.getLanguageKey().getName());


            lBusiness.setLanguageKey(lKey);
            lBusiness.setLast_update(dto.getLast_update());

            business.setLanguage(lBusiness);

        }
        return business;
    }

    public FilmDTO businessToDto(Film business){
        FilmDTO dto = new FilmDTO();
        dto.setId(business.getId());
        dto.setTitle(business.getTitle());
        dto.setDescription(business.getDescription());
        dto.setRelease_year(business.getRelease_year());
        dto.setRental_rate(business.getRental_rate());
        dto.setLast_update(business.getLast_update());

        if (business.getCatCategory() != null){
            CategoryDTO categoryDTO =  new CategoryDTO();
            categoryDTO.setId(business.getCatCategory().getId());
            categoryDTO.setName(business.getCatCategory().getName());
            categoryDTO.setLast_update(business.getCatCategory().getLast_update());
            dto.setCategory(categoryDTO);
        }

        if (business.getLanguage() != null) {
            LanguageDTO lDto = new LanguageDTO();
            LanguageKeyDTO key = new LanguageKeyDTO();

            key.setCountry(business.getLanguage().getLanguageKey().getCountry());
            key.setName(business.getLanguage().getLanguageKey().getName());

            lDto.setLanguageKey(key);
            lDto.setLast_update(business.getLast_update());
            dto.setLanguageKey(key);

        }


        return dto;
    }
}

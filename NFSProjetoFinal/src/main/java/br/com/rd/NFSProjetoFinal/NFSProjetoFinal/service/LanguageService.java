package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.service;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.LanguageDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.LanguageKeyDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Language;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.embeddable.LanguageKey;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    @Autowired
    LanguageRepository languageRepository;

    public LanguageDTO add(LanguageDTO language) throws SQLIntegrityConstraintViolationException {
        Language lang = dtoToBusiness(language);
        if (languageRepository.existsById(lang.getLanguageKey())){
            throw new SQLIntegrityConstraintViolationException("Primary Key já existe!");
        }
        lang = languageRepository.save(lang);
        return businessToDto(lang);
    }

    public List<LanguageDTO> findAll(){
        List<Language> list = languageRepository.findAll();
        return listToDto(list);
    }

    private List <LanguageDTO> listToDto(List<Language> list){
        List<LanguageDTO> listDto = new ArrayList<LanguageDTO>();
        for (Language l: list){
            listDto.add(this.businessToDto(l));
        }
        return listDto;
    }

    public LanguageDTO searchCountryName (String country, String name){
        LanguageKey key = new LanguageKey();
        key.setCountry(country);
        key.setName(name);

        Optional <Language> lang = languageRepository.findById(key);

        if(lang.isPresent()){
            return businessToDto(lang.get());
        }
        return null;
    }

    public List <LanguageDTO> searchAllByCountry (String country){
        List<Language> list = languageRepository.findByLanguageKeyCountry(country);
        return listToDto(list);

    }


    private LanguageDTO businessToDto(Language lang){
        LanguageDTO dto = new LanguageDTO();
        LanguageKeyDTO key = new LanguageKeyDTO();

        key.setCountry(lang.getLanguageKey().getCountry());
        key.setName(lang.getLanguageKey().getName());

        dto.setLanguageKey(key);
        dto.setLast_update(lang.getLast_update());
        return dto;
    }

    private Language dtoToBusiness(LanguageDTO langDTO){
        Language business = new Language();
        LanguageKey key = new LanguageKey();

        key.setName(langDTO.getLanguageKey().getName());
        key.setCountry(langDTO.getLanguageKey().getCountry());

        business.setLanguageKey(key);
        business.setLast_update(langDTO.getLast_update());
        return business;
    }



}

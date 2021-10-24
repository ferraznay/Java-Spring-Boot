package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.service;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.CategoryDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.Entity.Category;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.repository.contract.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDTO addCategory(CategoryDTO category){
        Category newCategory = this.dtoToBusiness(category);
        newCategory = categoryRepository.save(newCategory);
        return this.businessToDto(newCategory);
    }


    public List<CategoryDTO> findAllCategory(){
        List<Category> allList = categoryRepository.findAll();
        return this.listToCategoryDto(allList);
    }

    public List<CategoryDTO> listToCategoryDto(List<Category> list){
        List<CategoryDTO> listCategoryDto = new ArrayList<CategoryDTO>();
        for (Category c : list){
            listCategoryDto.add(this.businessToDto(c));
        }
        return listCategoryDto;
    }

    public CategoryDTO searchCategoryById(Long id){
        Optional<Category> op = categoryRepository.findById(id);

        if(op.isPresent()){
            return businessToDto(op.get());
        }
        return null;
    }


    public CategoryDTO updateByCategoryId(CategoryDTO dto, Long id){
        Optional<Category> op = categoryRepository.findById(id);

        if (op.isPresent()){
            Category obj = op.get();
            if (dto.getName() != null){
                obj.setName(dto.getName());
            }
            if (dto.getLast_update() != null){
                obj.setLast_update(dto.getLast_update());
            }

            categoryRepository.save(obj);
            return businessToDto(obj);
        }
        return null;
    }

    public void deleteByCategoryId(Long id){
        if(categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        }
    }


    public Category dtoToBusiness(CategoryDTO dto){
        Category business = new Category();
        business.setName(dto.getName());
        business.setLast_update(dto.getLast_update());
        return business;
    }

    public CategoryDTO businessToDto(Category business){
        CategoryDTO dto = new CategoryDTO();
        dto.setId(business.getId());
        dto.setName(business.getName());
        dto.setLast_update(business.getLast_update());
        return dto;
    }



}

package br.com.rd.NFSProjetoFinal.NFSProjetoFinal.controller;

import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.model.DTO.CategoryDTO;
import br.com.rd.NFSProjetoFinal.NFSProjetoFinal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping

    public CategoryDTO create(@RequestBody CategoryDTO category){

        return categoryService.addCategory(category);
    }


    @GetMapping
    public List<CategoryDTO> findAll(){

        return categoryService.findAllCategory();
    }

    @GetMapping ("/{id}")
    public CategoryDTO searchCategoryById(@PathVariable ("id") Long id){

        return categoryService.searchCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryDTO updateByCategoryId(@RequestBody CategoryDTO dto, @PathVariable("id") Long id){
        return categoryService.updateByCategoryId(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByCategoryId(@PathVariable("id") Long id){
        categoryService.deleteByCategoryId(id);
    }
}

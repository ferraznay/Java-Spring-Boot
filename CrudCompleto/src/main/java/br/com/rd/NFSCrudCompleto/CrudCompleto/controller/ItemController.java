package br.com.rd.NFSCrudCompleto.CrudCompleto.controller;


import br.com.rd.NFSCrudCompleto.CrudCompleto.model.DTO.ItemDTO;
import br.com.rd.NFSCrudCompleto.CrudCompleto.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping

    public ItemDTO create(@RequestBody ItemDTO item){

        return itemService.addItem(item);
    }

    @GetMapping
    public List<ItemDTO> findAll(){

        return itemService.findAllItem();
    }

    @GetMapping ("/{id}")
    public ItemDTO searchByID(@PathVariable ("id") Long id){

        return itemService.searchItemById(id);
    }

    @PutMapping("/{id}")
    public ItemDTO updateByItemId(@RequestBody ItemDTO dto, @PathVariable("id") Long id){
        return itemService.updateByItemId(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByItemId(@PathVariable("id") Long id){
        itemService.deleteByItemId(id);
    }

}

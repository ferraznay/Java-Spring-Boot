package br.com.rd.NFSCrudCompleto.CrudCompleto.controller;


import br.com.rd.NFSCrudCompleto.CrudCompleto.model.DTO.CarrinhoDTO;
import br.com.rd.NFSCrudCompleto.CrudCompleto.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    CarrinhoService carrinhoService;

    @PostMapping

    public CarrinhoDTO create(@RequestBody CarrinhoDTO carrinho){

        return carrinhoService.addCarrinho(carrinho);
    }


    @GetMapping
    public List<CarrinhoDTO> findAll(){

        return carrinhoService.findAllCarrinho();
    }

    @GetMapping ("/{id}")
    public CarrinhoDTO searchByID(@PathVariable ("id") Long id){

        return carrinhoService.searchCarrinhoById(id);
    }

    @PutMapping("/{id}")
    public CarrinhoDTO updateByCarrinhoId(@RequestBody CarrinhoDTO dto, @PathVariable("id") Long id){
        return carrinhoService.updateByCarrinhoId(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByCarrinhoId(@PathVariable("id") Long id){
        carrinhoService.deleteByCarrinhoId(id);
    }
}

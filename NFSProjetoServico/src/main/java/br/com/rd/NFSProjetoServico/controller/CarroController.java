package br.com.rd.NFSProjetoServico.controller;

import br.com.rd.NFSProjetoServico.model.Entity.Carro;
import br.com.rd.NFSProjetoServico.model.Entity.Vehicle;
import br.com.rd.NFSProjetoServico.model.VehicleDTO.CarroDTO;
import br.com.rd.NFSProjetoServico.model.VehicleDTO.VehicleDTO;
import br.com.rd.NFSProjetoServico.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @Autowired
    CarroService carroService;

    @PostMapping

    public CarroDTO create(@RequestBody CarroDTO carro){

        return carroService.addCarro(carro);
    }


    @GetMapping
    public List<CarroDTO> findAll(){

        return carroService.findAllCarro();
    }

    @GetMapping ("/{id}")
    public CarroDTO searchByID(@PathVariable ("id") Long id){

        return carroService.searchCarroById(id);
    }

    @PutMapping("/{id}")
        public CarroDTO updateByCarroId(@RequestBody CarroDTO dto, @PathVariable("id") Long id){
        return carroService.updateByCarroId(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT) // No content não permite retornp de objeto
    public void deleteByCarroId(@PathVariable("id") Long id){
        carroService.deleteByCarroId(id);
    }


}

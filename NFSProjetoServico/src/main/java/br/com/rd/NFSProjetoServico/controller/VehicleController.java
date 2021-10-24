package br.com.rd.NFSProjetoServico.controller;

import br.com.rd.NFSProjetoServico.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.rd.NFSProjetoServico.model.VehicleDTO.VehicleDTO;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

@Autowired
    VehicleService vehicleService;

    @PostMapping

    public VehicleDTO create(@RequestBody VehicleDTO vehicle){

        return vehicleService.addVehicle(vehicle);
    }


    @GetMapping
    public List<VehicleDTO> findAll(){

        return vehicleService.findAllVehicle();
    }

    @GetMapping ("/{id}")
    public VehicleDTO searchByID(@PathVariable ("id") Long id){

      return vehicleService.searchVehicleById(id);
    }

    @GetMapping("/searchByYear/{year}")
    public List<VehicleDTO> searchByYear (@PathVariable("year") Integer year){
        return vehicleService.searchAllByYear(year);
    }
    @GetMapping("/searchByBrand/{brand}")
    public List<VehicleDTO> searchByBrand (@PathVariable("brand") String brand){
        return vehicleService.searchAllByBrand(brand);
    }
    @GetMapping("/searchByModel/{model}")
    public List<VehicleDTO> searchByModel (@PathVariable("model") String model){
        return vehicleService.searchAllByModel(model);
    }



    @GetMapping("/searchByAll/{year}/{model}/{brand}")
    public List<VehicleDTO> retornaTodas(@PathVariable("year")Integer year,
                                        @PathVariable("brand")String brand,
                                        @PathVariable("model")String model) {
        return vehicleService.retornaTodas(year, brand, model);
    }

    @PutMapping("/{id}")
    public VehicleDTO updateById(@RequestBody VehicleDTO dto, @PathVariable("id") Long id){
        return vehicleService.updateById(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT) // No content não permite retornp de objeto
    public void deleteById(@PathVariable("id") Long id){
        vehicleService.deleteById(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public VehicleDTO deleteByIdReturningDTO(@PathVariable("id") Long id){
        return vehicleService.deleteByIdReturningDTO(id);
    }


}

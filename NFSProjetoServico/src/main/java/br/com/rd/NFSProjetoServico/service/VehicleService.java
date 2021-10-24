package br.com.rd.NFSProjetoServico.service;

import br.com.rd.NFSProjetoServico.model.Entity.Vehicle;
import br.com.rd.NFSProjetoServico.model.VehicleDTO.VehicleDTO;
import br.com.rd.NFSProjetoServico.repository.contract.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    public VehicleDTO addVehicle(VehicleDTO vehicle){
        Vehicle newVehicle = this.dtoToBusiness(vehicle);
        newVehicle =vehicleRepository.save(newVehicle);
        return this.businessToDto(newVehicle);
    }

    public List <VehicleDTO> findAllVehicle(){
        List<Vehicle> allList = vehicleRepository.findAll();
        return this.listToDto(allList);
    }

    public List<VehicleDTO> listToDto(List<Vehicle> list){
        List<VehicleDTO> listDto = new ArrayList<VehicleDTO>();
        for (Vehicle v : list){
            listDto.add(this.businessToDto(v));
        }
        return listDto;
    }

    public VehicleDTO searchVehicleById(Long id){
        Optional<Vehicle> op = vehicleRepository.findById(id);

        if(op.isPresent()){
            return businessToDto(op.get());
        }
        return null;
    }

    public List<VehicleDTO> searchAllByYear(Integer year){
        List<Vehicle> vehicleList = vehicleRepository.retornaDia(year);
        return  listToDto(vehicleList);
    }
    public List<VehicleDTO> searchAllByBrand(String brand){
        List<Vehicle> vehicleList = vehicleRepository.retornaBrand(brand) ;
        return  listToDto(vehicleList);
    }
    public List<VehicleDTO> searchAllByModel(String model){
        List<Vehicle> vehicleList = vehicleRepository.retornaModel(model) ;
        return  listToDto(vehicleList);
    }

    public List<VehicleDTO> retornaTodas(Integer year, String brand, String model){
        List<Vehicle> vehicleList = vehicleRepository.retornaTodas(year, brand, model) ;
        return  listToDto(vehicleList);
    }


    public VehicleDTO updateById(VehicleDTO dto, Long id){
        Optional<Vehicle> op = vehicleRepository.findById(id);

        if (op.isPresent()){
            Vehicle obj = op.get();
            if (dto.getBrand() != null){
                obj.setBrand(dto.getBrand());
            }
            if (dto.getModel() != null){
                obj.setModel(dto.getModel());
            }
            if (dto.getYear() != null){
                obj.setYear(dto.getYear());
            }

            vehicleRepository.save(obj);
            return businessToDto(obj);
        }
        return null;
    }

    public void deleteById(Long id){
        if(vehicleRepository.existsById(id)){
            vehicleRepository.deleteById(id);
        }
    }

    public VehicleDTO deleteByIdReturningDTO(Long id){
        VehicleDTO retorno = this.searchVehicleById(id);
        if(vehicleRepository.existsById(id)){
            vehicleRepository.deleteById(id);
        }
        return retorno;
    }


    public Vehicle dtoToBusiness(VehicleDTO dto){
        Vehicle business = new Vehicle();
        business.setBrand(dto.getBrand());
        business.setModel(dto.getModel());
        business.setYear(dto.getYear());
        return business;
    }

    public VehicleDTO businessToDto(Vehicle business){
        VehicleDTO dto = new VehicleDTO();
        dto.setId(business.getId());
        dto.setBrand(business.getBrand());
        dto.setModel(business.getModel());
        dto.setYear(business.getYear());
        return dto;
    }

}

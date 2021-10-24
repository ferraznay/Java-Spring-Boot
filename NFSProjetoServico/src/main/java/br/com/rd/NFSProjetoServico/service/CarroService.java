package br.com.rd.NFSProjetoServico.service;

import br.com.rd.NFSProjetoServico.model.Entity.Carro;
import br.com.rd.NFSProjetoServico.model.Entity.Media;
import br.com.rd.NFSProjetoServico.model.VehicleDTO.CarroDTO;
import br.com.rd.NFSProjetoServico.model.VehicleDTO.MediaDTO;
import br.com.rd.NFSProjetoServico.repository.contract.CarroRepository;
import br.com.rd.NFSProjetoServico.repository.contract.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;
    @Autowired
    MediaRepository mediaRepository;

    public CarroDTO addCarro(CarroDTO carro) {
        Carro newCarro = this.carroDtoToBusiness(carro);

        if (newCarro.getCarMedia() != null) {
            // Sem CascadeType
            Long id = newCarro.getCarMedia().getId();
            Media m;
            if (id != null) {
                m = this.mediaRepository.getById(id);
            } else {
                m = this.mediaRepository.save(newCarro.getCarMedia());
            }
            newCarro.setCarMedia(m);

//            CascadeType.PERSIST
//                    Long id = newCarro.getCarMedia().getId();
//            if (id != null){
//                Media m = this.mediaRepository.getById(id);
//                newCarro.setCarMedia(m);
//            }
        }
        newCarro = carroRepository.save(newCarro);
        return this.carroBusinessToDto(newCarro);
    }

    public List<CarroDTO> findAllCarro(){
        List<Carro> allList = carroRepository.findAll();
        return this.listToCarroDto(allList);
    }

    public List<CarroDTO> listToCarroDto(List<Carro> list){
        List<CarroDTO> listCarroDto = new ArrayList<CarroDTO>();
        for (Carro c : list){
            listCarroDto.add(this.carroBusinessToDto(c));
        }
        return listCarroDto;
    }

    public CarroDTO searchCarroById(Long id){
        Optional<Carro> op = carroRepository.findById(id);

        if(op.isPresent()){
            return carroBusinessToDto(op.get());
        }
        return null;
    }


    public CarroDTO updateByCarroId(CarroDTO dto, Long id){
        Optional<Carro> op = carroRepository.findById(id);

        if (op.isPresent()){
            Carro obj = op.get();
            if (dto.getBrand() != null){
                obj.setBrand(dto.getBrand());
            }
            if (dto.getModel() != null){
                obj.setModel(dto.getModel());
            }
            if (dto.getColor() != null){
                obj.setColor(dto.getColor());
            }
            if (dto.getYear() != null){
                obj.setYear(dto.getYear());
            }

            carroRepository.save(obj);
            return carroBusinessToDto(obj);
        }
        return null;
    }

    public void deleteByCarroId(Long id){
        if(carroRepository.existsById(id)){
            carroRepository.deleteById(id);
        }
    }


    public Carro carroDtoToBusiness(CarroDTO dto){
        Carro business = new Carro();
        business.setBrand(dto.getBrand());
        business.setModel(dto.getModel());
        business.setColor(dto.getColor());
        business.setYear(dto.getYear());

        if (dto.getMedia() != null){
            Media m = new Media();
            if (dto.getMedia().getId() != null){
                m.setId(dto.getMedia().getId());
            }else {
                m.setDescription(dto.getMedia().getDescription());
                m.setTouch(dto.getMedia().getTouch());
            }
            business.setCarMedia(m);
        }
        return business;
    }

    public CarroDTO carroBusinessToDto(Carro business){
        CarroDTO dto = new CarroDTO();
        dto.setId(business.getId());
        dto.setBrand(business.getBrand());
        dto.setModel(business.getModel());
        dto.setColor(business.getColor());
        dto.setYear(business.getYear());

       if (business.getCarMedia() != null){
           MediaDTO mediaDTO = new MediaDTO();
           mediaDTO.setId(business.getCarMedia().getId());
           mediaDTO.setDescription(business.getCarMedia().getDescription());
           mediaDTO.setTouch(business.getCarMedia().getTouch());
           dto.setMedia(mediaDTO);
       }
        return dto;
    }

}

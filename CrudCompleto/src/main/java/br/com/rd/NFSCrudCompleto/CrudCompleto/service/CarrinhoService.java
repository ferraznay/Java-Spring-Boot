package br.com.rd.NFSCrudCompleto.CrudCompleto.service;

import br.com.rd.NFSCrudCompleto.CrudCompleto.model.DTO.CarrinhoDTO;
import br.com.rd.NFSCrudCompleto.CrudCompleto.model.Entity.Carrinho;
import br.com.rd.NFSCrudCompleto.CrudCompleto.repository.contract.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {
    @Autowired
    CarrinhoRepository carrinhoRepository;

    public CarrinhoDTO addCarrinho(CarrinhoDTO carrinho){
        Carrinho newCarrinho= this.dtoToBusiness(carrinho);
        newCarrinho = carrinhoRepository.save(newCarrinho);
        return this.businessToDto(newCarrinho);
    }

    public List<CarrinhoDTO> findAllCarrinho(){
        List<Carrinho> allList = carrinhoRepository.findAll();
        return this.listToCarrinhoDto(allList);
    }

    public List<CarrinhoDTO> listToCarrinhoDto(List<Carrinho> list){
        List<CarrinhoDTO> listCarrinhoDto = new ArrayList<CarrinhoDTO>();
        for (Carrinho c : list){
            listCarrinhoDto.add(this.businessToDto(c));
        }
        return listCarrinhoDto;
    }

    public CarrinhoDTO searchCarrinhoById(Long id){
        Optional<Carrinho> op = carrinhoRepository.findById(id);

        if(op.isPresent()){
            return businessToDto(op.get());
        }
        return null;
    }


    public CarrinhoDTO updateByCarrinhoId(CarrinhoDTO dto, Long id){
        Optional<Carrinho> op = carrinhoRepository.findById(id);

        if (op.isPresent()){
            Carrinho obj = op.get();
            if (dto.getUsuario() != null){
                obj.setUsuario(dto.getUsuario());
            }

            carrinhoRepository.save(obj);
            return businessToDto(obj);
        }
        return null;
    }

    public void deleteByCarrinhoId(Long id){
        if(carrinhoRepository.existsById(id)){
            carrinhoRepository.deleteById(id);
        }
    }


    public Carrinho dtoToBusiness(CarrinhoDTO dto){
        Carrinho business = new Carrinho();
        business.setUsuario(dto.getUsuario());
        return business;
    }

    public CarrinhoDTO businessToDto(Carrinho business){
        CarrinhoDTO dto = new CarrinhoDTO();
        dto.setId(business.getId());
        dto.setUsuario(business.getUsuario());
        return dto;
    }



}

package br.com.rd.NFSCrudCompleto.CrudCompleto.service;

import br.com.rd.NFSCrudCompleto.CrudCompleto.model.DTO.CarrinhoDTO;
import br.com.rd.NFSCrudCompleto.CrudCompleto.model.DTO.ItemDTO;
import br.com.rd.NFSCrudCompleto.CrudCompleto.model.Entity.Carrinho;
import br.com.rd.NFSCrudCompleto.CrudCompleto.model.Entity.Item;
import br.com.rd.NFSCrudCompleto.CrudCompleto.repository.contract.CarrinhoRepository;
import br.com.rd.NFSCrudCompleto.CrudCompleto.repository.contract.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CarrinhoRepository carrinhoRepository;

    public ItemDTO addItem(ItemDTO item){
        Item newItem= this.dtoToBusiness(item);

        if (newItem.getCarCarrinho() != null){
            Long id = newItem.getCarCarrinho().getId();
            Carrinho c;
            if (id != null){
                c = this.carrinhoRepository.getById(id);
            }else {
                c = this.carrinhoRepository.save(newItem.getCarCarrinho());
            }
            newItem.setCarCarrinho(c);
        }


        newItem = itemRepository.save(newItem);
        return this.businessToDto(newItem);
    }

    public List<ItemDTO> findAllItem(){
        List<Item> allList = itemRepository.findAll();
        return this.listToItemDto(allList);
    }

    public List<ItemDTO> listToItemDto(List<Item> list){
        List<ItemDTO> listItemDto = new ArrayList<ItemDTO>();
        for (Item i : list){
            listItemDto.add(this.businessToDto(i));
        }
        return listItemDto;
    }

    public ItemDTO searchItemById(Long id){
        Optional<Item> op = itemRepository.findById(id);

        if(op.isPresent()){
            return businessToDto(op.get());
        }
        return null;
    }


    public ItemDTO updateByItemId(ItemDTO dto, Long id){
        Optional<Item> op = itemRepository.findById(id);

        if (op.isPresent()){
            Item obj = op.get();
            if (dto.getDescricao() != null){
                obj.setDescricao(dto.getDescricao());
            }

            itemRepository.save(obj);
            return businessToDto(obj);
        }
        return null;
    }

    public void deleteByItemId(Long id){
        if(itemRepository.existsById(id)){
            itemRepository.deleteById(id);
        }
    }


    public Item dtoToBusiness(ItemDTO dto){
        Item business = new Item();
        business.setDescricao(dto.getDescricao());
        if (dto.getCarrinho() != null){
            Carrinho c = new Carrinho();
            if (dto.getCarrinho().getId() != null){
                c.setId(dto.getCarrinho().getId());
            }else {
                c.setUsuario(dto.getCarrinho().getUsuario());

            }
            business.setCarCarrinho(c);
        }
        return business;
    }

    public ItemDTO businessToDto(Item business){
        ItemDTO dto = new ItemDTO();
        dto.setId(business.getId());
        dto.setDescricao(business.getDescricao());

        if (business.getCarCarrinho() != null){
            CarrinhoDTO carrinhoDTO = new CarrinhoDTO();
            carrinhoDTO.setId(business.getCarCarrinho().getId());
            carrinhoDTO.setUsuario(business.getCarCarrinho().getUsuario());

            dto.setCarrinho(carrinhoDTO);
        }

        return dto;
    }
}

package br.com.rd.NFSProjetoServico.service;


import br.com.rd.NFSProjetoServico.model.Entity.Media;
import br.com.rd.NFSProjetoServico.model.VehicleDTO.MediaDTO;
import br.com.rd.NFSProjetoServico.repository.contract.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService {
    @Autowired
    MediaRepository mediaRepository;

    public MediaDTO addMedia(MediaDTO media){
        Media newMedia= this.mediaDtoToBusiness(media);
        newMedia = mediaRepository.save(newMedia);
        return this.mediaBusinessToDto(newMedia);
    }

    public List<MediaDTO> findAllMedia(){
        List<Media> allList = mediaRepository.findAll();
        return this.listToMediaDto(allList);
    }

    public List<MediaDTO> listToMediaDto(List<Media> list){
        List<MediaDTO> listMediaDto = new ArrayList<MediaDTO>();
        for (Media m : list){
            listMediaDto.add(this.mediaBusinessToDto(m));
        }
        return listMediaDto;
    }

    public MediaDTO searchMediaById(Long id){
        Optional<Media> op = mediaRepository.findById(id);

        if(op.isPresent()){
            return mediaBusinessToDto(op.get());
        }
        return null;
    }


    public MediaDTO updateByMediaId(MediaDTO dto, Long id){
        Optional<Media> op = mediaRepository.findById(id);

        if (op.isPresent()){
            Media obj = op.get();
            if (dto.getDescription() != null){
                obj.setDescription(dto.getDescription());
            }
            if (dto.getTouch() != null){
                obj.setTouch(dto.getTouch());
            }


            mediaRepository.save(obj);
            return mediaBusinessToDto(obj);
        }
        return null;
    }

    public void deleteByMediaId(Long id){
        if(mediaRepository.existsById(id)){
            mediaRepository.deleteById(id);
        }
    }


    public Media mediaDtoToBusiness(MediaDTO dto){
        Media business = new Media();
        business.setDescription(dto.getDescription());
        business.setTouch(dto.getTouch());
        return business;
    }

    public MediaDTO mediaBusinessToDto(Media business){
        MediaDTO dto = new MediaDTO();
        dto.setId(business.getId());
        dto.setDescription(business.getDescription());
        dto.setTouch(business.getTouch());
        return dto;
    }



}

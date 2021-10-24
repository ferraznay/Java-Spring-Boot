package br.com.rd.NFSProjetoServico.controller;

import br.com.rd.NFSProjetoServico.model.VehicleDTO.MediaDTO;
import br.com.rd.NFSProjetoServico.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/media")
public class MediaController {
    @Autowired
    MediaService mediaService;

    @PostMapping
    public MediaDTO create(@RequestBody MediaDTO media){

        return mediaService.addMedia(media);
    }


    @GetMapping
    public List<MediaDTO> findAll(){

        return mediaService.findAllMedia();
    }

    @GetMapping ("/{id}")
    public MediaDTO searchMediaById(@PathVariable ("id") Long id){

        return mediaService.searchMediaById(id);
    }

    @PutMapping("/{id}")
    public MediaDTO updateByMediaId(@RequestBody MediaDTO dto, @PathVariable("id") Long id){
        return mediaService.updateByMediaId(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT) // No content não permite retornp de objeto
    public void deleteByMediaId(@PathVariable("id") Long id){
        mediaService.deleteByMediaId(id);
    }



}

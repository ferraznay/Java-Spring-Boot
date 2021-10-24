package br.com.rd.NFSProjetoServico.model.VehicleDTO;

import lombok.Data;

@Data
public class CarroDTO {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private Integer year;
    private MediaDTO media;



}

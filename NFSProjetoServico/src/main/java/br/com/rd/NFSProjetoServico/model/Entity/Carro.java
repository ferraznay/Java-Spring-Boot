package br.com.rd.NFSProjetoServico.model.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name="carro")
@Data
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private Integer year;


    //@ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cl_media")
    private Media carMedia;


}

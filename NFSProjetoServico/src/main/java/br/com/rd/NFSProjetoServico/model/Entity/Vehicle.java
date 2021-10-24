package br.com.rd.NFSProjetoServico.model.Entity;

import javax.persistence.*;



@Entity(name="tb_vehicle")
public class Vehicle {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false, name = "cl_brand")
    private String brand;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private Integer year;


    public Long getId(){
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand(){
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel(){
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear(){
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

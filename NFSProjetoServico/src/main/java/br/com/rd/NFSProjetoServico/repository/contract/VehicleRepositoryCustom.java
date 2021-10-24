package br.com.rd.NFSProjetoServico.repository.contract;

import br.com.rd.NFSProjetoServico.model.Entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepositoryCustom {
//    List<Vehicle> findAllByYear(Integer year);
    @Query(value = "SELECT * FROM tb_vehicle tv " +
                "WHERE tv.YEAR = :year", nativeQuery = true)
    List<Vehicle> retornaDia(@Param("year") Integer year);

    @Query(value = "SELECT * FROM tb_vehicle tv " +
            "WHERE tv.CL_BRAND = :brand", nativeQuery = true)
    List<Vehicle> retornaBrand(@Param("brand") String brand);

    @Query(value = "SELECT * FROM tb_vehicle tv " +
            "WHERE tv.MODEL = :model", nativeQuery = true)
    List<Vehicle> retornaModel(@Param("model") String model);


    @Query(value =  " SELECT * FROM tb_vehicle tv WHERE tv.YEAR = :year AND tv.CL_BRAND = :brand AND tv.MODEL = :model", nativeQuery = true)
    List<Vehicle> retornaTodas(
            @Param("year") Integer year,
            @Param("brand") String brand,
            @Param("model") String model);
}




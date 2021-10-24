package br.com.rd.NFSProjetoServico.repository.contract;

import br.com.rd.NFSProjetoServico.model.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>, VehicleRepositoryCustom {
//    List<Vehicle> retornaDia(Integer year);

}

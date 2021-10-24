package br.com.rd.NFSProjetoCrudTaskManager.repository.contract;

import br.com.rd.NFSProjetoCrudTaskManager.model.Entity.TaskManager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;

import java.util.List;

public interface MyFindAllByDescriptionDoneCustom {
      @Query(value = " SELECT * FROM TASK_MANAGER TM WHERE TM.DESCRICAO LIKE %:busca% AND TM.FEITO = TRUE", nativeQuery = true)
      List<TaskManager> buscaDescricao(
              @Param("busca") String busca);

//
      @Query(value = " SELECT * FROM TASK_MANAGER TM ORDER BY TM.DATA_DE_ATUALIZACAO DESC", nativeQuery = true)
      List<TaskManager> dataDecrescente(
              @Param("dataDeAtualizacao") LocalDate dataDeAtualizacao);

      @Query(value = " SELECT * FROM TASK_MANAGER TM WHERE TM.FEITO = TRUE ORDER BY TM.DATA_DE_ATUALIZACAO DESC ", nativeQuery = true)
      List<TaskManager> dataTarefaTerminada(
              @Param("dataDeAtualizacao") LocalDate dataDeAtualizacao);

}



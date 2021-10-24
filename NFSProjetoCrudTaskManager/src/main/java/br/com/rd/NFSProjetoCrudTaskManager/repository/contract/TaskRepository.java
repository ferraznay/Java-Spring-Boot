package br.com.rd.NFSProjetoCrudTaskManager.repository.contract;

import br.com.rd.NFSProjetoCrudTaskManager.model.Entity.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskManager, Long>, MyFindAllByDescriptionDoneCustom {

}

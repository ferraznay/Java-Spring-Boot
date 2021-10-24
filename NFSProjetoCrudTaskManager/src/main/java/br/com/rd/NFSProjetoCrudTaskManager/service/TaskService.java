package br.com.rd.NFSProjetoCrudTaskManager.service;

import br.com.rd.NFSProjetoCrudTaskManager.model.Entity.TaskManager;
import br.com.rd.NFSProjetoCrudTaskManager.model.TaskDTO.TaskDTO;
import br.com.rd.NFSProjetoCrudTaskManager.repository.contract.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    public TaskDTO addTask(TaskDTO task){
        TaskManager newTask = this.taskDtoToBusiness(task);
        newTask = taskRepository.save(newTask);
        return this.taskBusinessToDto(newTask) ;
    }

    public List<TaskDTO> findAllTask(){
    List<TaskManager> allList = taskRepository.findAll();
        return this.listToTaskDto(allList);
    }



    public List<TaskDTO> listToTaskDto(List<TaskManager> list){
        List<TaskDTO> listTaskDto = new ArrayList<TaskDTO>();
        for (TaskManager t : list){
            listTaskDto.add(this.taskBusinessToDto(t));
        }
        return listTaskDto;
    }

    public TaskDTO searchTaskById(Long id){
        Optional<TaskManager> op = taskRepository.findById(id);

        if(op.isPresent()){
            return taskBusinessToDto(op.get());
        }
        return null;
    }

    public TaskDTO updateByTaskId(TaskDTO dto, Long id){
        Optional<TaskManager> op = taskRepository.findById(id);

        if (op.isPresent()){
            TaskManager obj = op.get();

            if(dto.getDescricao() != null){
                obj.setDescricao(dto.getDescricao());
            }
            if(dto.getFeito() != null){
                obj.setFeito(dto.getFeito());
            }
            if(dto.getDataDeAtualizacao() != null){
                obj.setDataDeAtualizacao(dto.getDataDeAtualizacao());
            }
            if (dto.getPorcetagemConclusao() != null){
                obj.setPorcetagemConclusao(dto.getPorcetagemConclusao());
            }
            if (dto.getPorcetagemConclusao() != null){
                obj.setPorcetagemConclusao(dto.getPorcetagemConclusao());
            }
            taskRepository.save(obj);
            return taskBusinessToDto(obj);
        }
        return null;
    }

    public void deleteByTaskId(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }
    }

    public List<TaskDTO> buscaDescricao(String descricao){
        List<TaskManager> taskManagerList = taskRepository.buscaDescricao(descricao);
        return listToTaskDto(taskManagerList);
    }
    public List<TaskDTO> dataDecrescente(LocalDate dataDeAtualizacao){
        List<TaskManager> taskManagerList = taskRepository.dataDecrescente(dataDeAtualizacao);
        return listToTaskDto(taskManagerList);
    }

    public List<TaskDTO> dataTarefaTerminada(LocalDate dataDeAtualizacao){
        List<TaskManager> taskManagerList = taskRepository.dataTarefaTerminada(dataDeAtualizacao);
        return listToTaskDto(taskManagerList);
    }



    private TaskManager taskDtoToBusiness(TaskDTO dto){
        TaskManager business = new TaskManager();
        business.setDescricao(dto.getDescricao());
        business.setFeito(dto.getFeito());
        business.setDataDeAtualizacao(dto.getDataDeAtualizacao());
        business.setPorcetagemConclusao(dto.getPorcetagemConclusao());
        return business;
    }

    private TaskDTO taskBusinessToDto(TaskManager business){
        TaskDTO dto = new TaskDTO();
        dto.setId(business.getId());
        dto.setDescricao(business.getDescricao());
        dto.setFeito(business.getFeito());
        dto.setDataDeAtualizacao(business.getDataDeAtualizacao());
        dto.setPorcetagemConclusao(business.getPorcetagemConclusao());
        return dto;
    }


}

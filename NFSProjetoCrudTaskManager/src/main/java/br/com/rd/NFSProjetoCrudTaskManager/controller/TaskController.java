package br.com.rd.NFSProjetoCrudTaskManager.controller;


import br.com.rd.NFSProjetoCrudTaskManager.model.TaskDTO.TaskDTO;
import br.com.rd.NFSProjetoCrudTaskManager.repository.contract.TaskRepository;
import br.com.rd.NFSProjetoCrudTaskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping (value = "/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public TaskDTO create(@RequestBody TaskDTO task){

        return taskService.addTask(task);
    }

    @GetMapping
    public List<TaskDTO> findAll(){

        return taskService.findAllTask();
    }

    @GetMapping ("/{id}")
    public TaskDTO searchTaskById(@PathVariable ("id") Long id){

        return taskService.searchTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskDTO updateByTaskId(@RequestBody TaskDTO dto, @PathVariable("id") Long id){
        return taskService.updateByTaskId(dto,id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteByTaskId(@PathVariable("id") Long id){
        taskService.deleteByTaskId(id);
    }

    @GetMapping("/por-descricao/{busca}")
    public List<TaskDTO> findUserByDescricaoLike(@PathVariable("busca") String busca){
        return taskService.buscaDescricao(busca);
    }

    @GetMapping("/ordenar-data")

    public List<TaskDTO> dataDecrescente(LocalDate dataDeAtualizacao){
        return taskService.dataDecrescente(dataDeAtualizacao);
    }

    @GetMapping("/data-tarefa-terminada")

    public List<TaskDTO> dataTarefaTerminada(LocalDate dataDeAtualizacao){
        return taskService.dataTarefaTerminada(dataDeAtualizacao);
    }

}

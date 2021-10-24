package com.example.NFSTesteRequisicoes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

@Controller

@RequestMapping("/")

public class NFSTeste {
    @GetMapping
    public @ResponseBody String hora() {
        Calendar hoje = Calendar.getInstance();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String hora = data.format(hoje.getTime());
        return "Horario de hoje:" + hora;
    }

    @GetMapping("/caminhoNome")
    public @ResponseBody String bemVindo() {

        return "Bem-vindo";
    }

    @GetMapping("/{dynamic}")
    public @ResponseBody String dynamicPath(@PathVariable("dynamic") String endpoint){
        return "Endpoint atual " + endpoint;
    }
    @GetMapping("/calcularPotencia")
    public @ResponseBody Double calcularPotencia(@RequestParam(value="numero", required = false) Double val ){
        Double resultado = Math.pow(val , val);
        return resultado;
    }
    @GetMapping("/calcularSoma")
    public @ResponseBody Integer calcularSoma(@RequestParam(value="numero") Integer number, @RequestParam(value="numero2") Integer number2){
       Integer resultado = (number + number2);
        return resultado;
    }
    @PostMapping("/PrimeiroPost")
    public @ResponseBody String primeiroPost(@RequestBody Map<String, Object> teste){
        return teste.get("attribute").toString() + " - " + teste.get("texto").toString();

    }
    @PostMapping("/SegundoPost")
    public @ResponseBody String segundoPost(@RequestBody Carro car){
        return car.getModelo() + " - " + car.getAno();

    }
    @PostMapping("/TerceiroPost")
    public @ResponseBody String terceiroPost(@RequestBody String teste){
        return teste;

    }


}





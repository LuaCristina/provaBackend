package com.example.prova1.controller;

import com.example.prova1.models.Pessoa;
import com.example.prova1.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa")
    public List<Pessoa> getPessoa(){
        return pessoaService.getPessoaAll();
    }

    @PostMapping("/pessoa")
    public Pessoa createPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.createPessoa(pessoa);
    }



}

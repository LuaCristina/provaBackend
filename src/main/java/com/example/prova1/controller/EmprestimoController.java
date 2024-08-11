package com.example.prova1.controller;

import com.example.prova1.models.Emprestimo;
import com.example.prova1.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    @PostMapping("/emprestimos")
    public Emprestimo createEmprestimo(@RequestBody Emprestimo emprestimo) {
        // Define a data do empréstimo antes de salvar
        emprestimo.setDataEmprestimo(LocalDateTime.now());
        return emprestimoService.createEmprestimo(emprestimo.getLivro(), emprestimo.getPessoa());
    }

    @PutMapping("/emprestimos/{id}/devolucao")
    public void devolucaoLivro(@PathVariable Long id) {
        emprestimoService.devolucaoLivro(id);
    }
}

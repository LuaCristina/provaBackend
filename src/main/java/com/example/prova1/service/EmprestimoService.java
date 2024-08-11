package com.example.prova1.service;

import com.example.prova1.models.Emprestimo;
import com.example.prova1.models.Livro;
import com.example.prova1.models.Pessoa;
import com.example.prova1.repository.EmprestimoRepository;
import com.example.prova1.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private LivroRepository livroRepository;

    public Emprestimo createEmprestimo(Livro livro, Pessoa pessoa){
        var emprestimo = new Emprestimo();
        emprestimo.setLivro(livro);
        emprestimo.setPessoa(pessoa);
        emprestimo.setDataEmprestimo(LocalDateTime.now());
        livro.setStatus("emprestado");
        livroRepository.save(livro);
        return emprestimoRepository.save(emprestimo);
    }

    public void  devolucaoLivro(Long id){
        var emprestimo = emprestimoRepository.findById(id);
        var livro = emprestimo.get().getLivro();
        livro.setStatus("disponível");
        livroRepository.save(livro);
        emprestimoRepository.deleteById(id);
    }



}

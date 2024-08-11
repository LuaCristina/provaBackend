package com.example.prova1.controller;

import com.example.prova1.models.Livro;
import com.example.prova1.repository.LivroRepository;
import com.example.prova1.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/livros")
    public List<Livro> getLivro() {
        return livroService.getLivro();
    }

    @PostMapping("/livros")
    public Livro createLivro(@RequestBody Livro livro) {
        return livroService.createLivro(livro);
    }

    @GetMapping("livros/{id}")
    public Optional<Livro> findLivro(@PathVariable("id") Long id){
        return livroService.findLivro(id);
    }

    @PutMapping("livros/{id}")
    public Livro updateLivro(@PathVariable("id") Long id, @RequestBody Livro livro) {
        return livroService.updateLivro(livro, id);
    }

    @DeleteMapping("livros/{id}")
    public void deleteLivro(@PathVariable("id") Long id){
        livroService.deleteLivro(id);
    }



}
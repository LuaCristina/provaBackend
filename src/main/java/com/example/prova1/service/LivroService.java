package com.example.prova1.service;

import com.example.prova1.models.Livro;
import com.example.prova1.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getLivro(){
        return livroRepository.findAll();
    }

    public Livro createLivro(Livro livro){
        livro.setStatus("disponivel");
        return livroRepository.save(livro);
    }

    public Optional<Livro> findLivro(Long id){
        return livroRepository.findById(id);
    }

    public Livro updateLivro(Livro livro, Long id){
       var livroNovo = this.findLivro(id).get();
       livroNovo.setAutor(livro.getAutor());
       livroNovo.setTitulo(livro.getTitulo());
       livroNovo.setAnoDePublicacao(livro.getAnoDePublicacao());
       return livroRepository.save(livroNovo);
    }

    public void  deleteLivro(Long id){
       livroRepository.deleteById(id);
    }


}

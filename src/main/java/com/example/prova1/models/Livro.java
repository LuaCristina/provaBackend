package com.example.prova1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table (name="Livro")
@Getter
@Setter
@Entity
public class Livro {

   @Id
   @GeneratedValue
   Long id;
   @Column(name = "titulo", nullable = false, length = 100)
   String titulo;
   @Column(name = "autor", nullable = false, length = 100)

   String autor;
   @Column(name = "data",  length = 100)

   Date anoDePublicacao;
   @Column(nullable = false)

   String status;

   @OneToMany
   private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

}

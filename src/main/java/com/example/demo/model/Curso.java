package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @ManyToMany(mappedBy = "cursos")
    private Set<Aluno> alunos = new HashSet<>();

    public Curso() {}

    public Curso(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Set<Aluno> getAlunos() { return alunos; }
    public void setAlunos(Set<Aluno> alunos) { this.alunos = alunos; }
}

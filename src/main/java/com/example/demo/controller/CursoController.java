package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.model.Curso;
import com.example.demo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;  // Importa para converter Set para List

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // 1. Adicionar um novo curso
    @PostMapping
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody Curso curso) {
        Curso cursoCadastrado = cursoService.cadastrarCurso(curso);
        return new ResponseEntity<>(cursoCadastrado, HttpStatus.CREATED);
    }

    // 2. Listar todos os cursos
    @GetMapping
    public ResponseEntity<List<Curso>> getAllCursos() {
        List<Curso> cursos = cursoService.getAllCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    // 3. Listar todos os alunos matriculados em um curso
    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<Aluno>> listarAlunosEmCurso(@PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Converte Set<Aluno> para List<Aluno>
        List<Aluno> alunos = new ArrayList<>(curso.getAlunos());
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }
}

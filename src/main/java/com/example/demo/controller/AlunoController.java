package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.model.Curso;
import com.example.demo.service.AlunoService;
import com.example.demo.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno alunoCadastrado = alunoService.cadastrarAluno(aluno);
        return new ResponseEntity<>(alunoCadastrado, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/cursos/{cursoId}")
    public ResponseEntity<Aluno> matricularAlunoEmCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        Aluno aluno = alunoService.buscarPorId(id);
        Curso curso = cursoService.buscarPorId(cursoId);

        if (aluno == null || curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        aluno.getCursos().add(curso);
        alunoService.cadastrarAluno(aluno);

        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @DeleteMapping("/{id}/cursos/{cursoId}")
    public ResponseEntity<Aluno> removerAlunoDeCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        Aluno aluno = alunoService.buscarPorId(id);
        Curso curso = cursoService.buscarPorId(cursoId);

        if (aluno == null || curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        aluno.getCursos().remove(curso);
        alunoService.cadastrarAluno(aluno);

        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @GetMapping("/{id}/cursos")
    public ResponseEntity<Set<Curso>> listarCursosDeAluno(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        if (aluno == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(aluno.getCursos(), HttpStatus.OK);
    }

    @GetMapping("/cursos/{id}/alunos")
    public ResponseEntity<List<Aluno>> listarAlunosEmCurso(@PathVariable Long id) {
        Curso curso = cursoService.buscarPorId(id);
        if (curso == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Aluno> alunos = alunoService.getAlunosPorCurso(id);
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.getAllAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }
}

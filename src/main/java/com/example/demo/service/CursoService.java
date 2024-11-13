package com.example.demo.service;

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List; // Usar a classe java.util.List

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso cadastrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> getAllCursos() { // Deve ser java.util.List
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    }
}

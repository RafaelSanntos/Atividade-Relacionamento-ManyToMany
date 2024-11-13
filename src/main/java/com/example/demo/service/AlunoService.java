package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno cadastrarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno buscarPorId(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public List<Aluno> getAlunosPorCurso(Long cursoId) {
        return alunoRepository.findAllByCursosId(cursoId);
    }
}

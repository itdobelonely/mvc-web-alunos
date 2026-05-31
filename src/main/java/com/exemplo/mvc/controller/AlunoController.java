package com.exemplo.mvc.controller;

import com.exemplo.mvc.model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * CONTROLLER — coordena a interação entre Model e View.
 * Recebe requisições HTTP, aciona o Model e define qual View exibir.
 * Não contém regras de negócio nem HTML.
 */
@Controller
public class AlunoController {

    // Lista em memória (simples para fins didáticos)
    private final List<Aluno> alunos = new ArrayList<>();

    /**
     * GET /alunos → exibe o formulário de cadastro
     */
    @GetMapping("/alunos")
    public String formulario() {
        return "alunos-form"; // nome do template Thymeleaf
    }

    /**
     * POST /alunos → processa o cadastro e exibe a lista atualizada
     */
    @PostMapping("/alunos")
    public String cadastrar(
            @RequestParam String nome,
            @RequestParam String matricula,
            Model model
    ) {
        alunos.add(new Aluno(nome, matricula)); // delega a criação ao Model
        model.addAttribute("alunos", alunos);   // passa dados à View
        return "alunos-lista";
    }
}

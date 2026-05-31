package com.exemplo.mvc.model;

/**
 * MODEL — representa a entidade de negócio.
 * Contém os dados e regras de validação do Aluno.
 * Não conhece HTTP, HTML ou qualquer detalhe de infraestrutura.
 */
public class Aluno {

    private String nome;
    private String matricula;

    public Aluno(String nome, String matricula) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("Matrícula é obrigatória");
        }
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }
}

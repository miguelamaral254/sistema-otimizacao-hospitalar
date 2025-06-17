package br.com.biblioteca.domain.leitos;

public record LeitosSusENaoSUSDTO(
        Long id,
        String uf,
        int quantidadeSus,
        int quantidadeNaoSus,
        int ano
) { }
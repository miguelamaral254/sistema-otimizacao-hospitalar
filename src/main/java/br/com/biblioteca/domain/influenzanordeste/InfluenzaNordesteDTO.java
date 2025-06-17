package br.com.biblioteca.domain.influenzanordeste;

public record InfluenzaNordesteDTO(
        Long id,
        String uf,
        int jan,
        int feb,
        int mar,
        int apr,
        int may,
        int jun,
        int jul,
        int aug,
        int sep,
        int oct,
        int nov,
        int dec,
        int ano
) { }
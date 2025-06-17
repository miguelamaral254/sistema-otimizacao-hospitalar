package br.com.biblioteca.domain.leitos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "leitos_sus_nao_sus")
@AllArgsConstructor
@NoArgsConstructor
public class LeitosSusENaoSUS {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "uf")
    private String uf;

    @Column(name = "quantidade_sus")
    private int quantidadeSus;

    @Column(name = "quantidade_nao_sus")
    private int quantidadeNaoSus;

    @Column(name = "ano")
    private int ano;

}
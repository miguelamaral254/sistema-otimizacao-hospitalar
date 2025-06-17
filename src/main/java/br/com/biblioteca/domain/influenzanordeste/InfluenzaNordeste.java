package br.com.biblioteca.domain.influenzanordeste;

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
@Table(name = "influenza_regiao_nordeste")
@AllArgsConstructor
@NoArgsConstructor
public class InfluenzaNordeste {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "uf")
    private String uf;

    @Column(name = "jan")
    private int jan;

    @Column(name = "feb")
    private int feb;

    @Column(name = "mar")
    private int mar;

    @Column(name = "apr")
    private int apr;

    @Column(name = "may")
    private int may;

    @Column(name = "jun")
    private int jun;

    @Column(name = "jul")
    private int jul;

    @Column(name = "aug")
    private int aug;

    @Column(name = "sep")
    private int sep;

    @Column(name = "oct")
    private int oct;

    @Column(name = "nov")
    private int nov;

    @Column(name = "dec")
    private int dec;

    @Column(name = "ano")
    private int ano;
}
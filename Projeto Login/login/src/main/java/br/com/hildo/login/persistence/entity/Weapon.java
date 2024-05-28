package br.com.hildo.login.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.function.Function;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_weapon")
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patrimonio", nullable = false, unique = true)
    private String patrimonio;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "distribuicao", nullable = false)
    private String distribuicao;

    @Column(name = "propriedade", nullable = false)
    private String propriedade;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    @Column(name = "numeroSerie", nullable = false)
    private String numeroSerie;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "calibre", nullable = false)
    private String calibre;

    @Column(name = "cano", nullable = false)
    private int cano;

    @Column(name = "raias", nullable = false)
    private int raias;

    @Column(name = "acabamento", nullable = false)
    private String acabamento;


    public <R> R map(Function<Weapon, R> func){

        return  func.apply(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return id == weapon.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

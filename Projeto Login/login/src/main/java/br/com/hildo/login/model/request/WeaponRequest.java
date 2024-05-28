package br.com.hildo.login.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeaponRequest {



    @NotBlank
    private String patrimonio;

    @NotBlank
    private String tipo;

    @NotBlank
    private String distribuicao;

    @NotBlank
    private String propriedade;

    @NotBlank
    private String observacao;

    @NotBlank
    private String numeroSerie;

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    @NotBlank
    private String calibre;

    @NotBlank
    private int cano;

    @NotBlank
    private int raias;

    @NotBlank
    private String acabamento;
}

package br.com.hildo.login.model.response;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeaponResponse {


    private  Long id;


    private String patrimonio;


    private String tipo;


    private String distribuicao;


    private String propriedade;


    private String observacao;


    private String numeroSerie;


    private String marca;


    private String modelo;


    private String calibre;


    private int cano;


    private int raias;


    private String acabamento;

}

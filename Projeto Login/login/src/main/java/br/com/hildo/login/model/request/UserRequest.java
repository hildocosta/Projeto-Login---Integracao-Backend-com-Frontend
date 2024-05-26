package br.com.hildo.login.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {


    @NotBlank
    private String name;

    @NotBlank
    private String rg;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
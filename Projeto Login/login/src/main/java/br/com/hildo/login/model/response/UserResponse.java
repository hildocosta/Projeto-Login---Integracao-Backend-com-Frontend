package br.com.hildo.login.model.response;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {


    private Long id;


    private String name;


    private String email;

    private String password;
}


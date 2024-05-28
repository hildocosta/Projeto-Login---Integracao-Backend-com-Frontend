package br.com.hildo.login.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRequest {


    @NotBlank
    private String name;

    @NotBlank
    private String key;
}

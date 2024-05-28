package br.com.hildo.login.model.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResourceResponse {

    private Long id;

    private String name;

    private String key;
}

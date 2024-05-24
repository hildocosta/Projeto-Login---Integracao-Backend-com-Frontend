package br.com.hildo.login.service.mapper;

import br.com.hildo.login.model.response.UserResponse;
import br.com.hildo.login.persistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements Mapper<User, UserResponse> {


    @Override
    public UserResponse map(User input) {
        if(input == null){
            return  null;
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setId(input.getId());
        userResponse.setName(input.getName());
        userResponse.setEmail(input.getEmail());
        userResponse.setPassword(input.getPassword());

        return userResponse;

    }
}

package br.com.hildo.login.service.mapper;


import br.com.hildo.login.model.request.UserRequest;
import br.com.hildo.login.persistence.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements Mapper<UserRequest, User> {

    @Override
    public User map(UserRequest input) {
        if(input == null) {
            return null;
        }

        User user = new User();
        user.setName(input.getName());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());

        return user;


    }
}

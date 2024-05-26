package br.com.hildo.login.service;

import br.com.hildo.login.model.request.UserRequest;
import br.com.hildo.login.model.response.UserResponse;


import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponse create(UserRequest userRequest);

    List<UserResponse> getAll();

    Optional<UserResponse> update(Long id, UserRequest userRequest);

    Optional<UserResponse> get(Long id);

    boolean delete(Long id);
}

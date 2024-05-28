package br.com.hildo.login.service;

import br.com.hildo.login.model.request.ProfileRequest;
import br.com.hildo.login.model.response.ProfileResponse;


import java.util.List;
import java.util.Optional;

public interface ProfileService {

    ProfileResponse create(ProfileRequest profileRequest);

    List<ProfileResponse> getAll();

    Optional<ProfileResponse> update(Long id, ProfileRequest profileRequest);

    Optional<ProfileResponse> get(Long id);

    boolean delete(Long id);
}

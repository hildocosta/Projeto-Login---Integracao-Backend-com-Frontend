package br.com.hildo.login.service;

import br.com.hildo.login.model.request.WeaponRequest;
import br.com.hildo.login.model.response.WeaponResponse;

import java.util.List;
import java.util.Optional;

public interface WeaponService {
    WeaponResponse create(WeaponRequest weaponRequest);

    List<WeaponResponse> getAll();

    Optional<WeaponResponse> update(Long id, WeaponRequest weaponRequest);

    Optional<WeaponResponse> get(Long id);

    boolean delete(Long id);
}

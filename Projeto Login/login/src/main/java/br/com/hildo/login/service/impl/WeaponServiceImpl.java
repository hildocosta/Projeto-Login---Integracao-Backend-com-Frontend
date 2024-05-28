package br.com.hildo.login.service.impl;


import br.com.hildo.login.model.request.WeaponRequest;
import br.com.hildo.login.model.response.WeaponResponse;
import br.com.hildo.login.persistence.entity.Resource;
import br.com.hildo.login.persistence.entity.Weapon;
import br.com.hildo.login.persistence.repository.WeaponRepository;
import br.com.hildo.login.service.WeaponService;
import br.com.hildo.login.service.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.util.Assert.notNull;

@Service
public class WeaponServiceImpl implements WeaponService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private Mapper<WeaponRequest, Weapon> requestMapper;

    @Autowired
    private Mapper<Weapon, WeaponResponse> responseMapper;




    @Override
    public WeaponResponse create(WeaponRequest weaponRequest) {
        LOGGER.info("Criando o registro da arma");
        notNull(weaponRequest, "Request Inválida");

        Weapon weaponEntity = requestMapper.map(weaponRequest);
        Weapon savedWeapon = weaponRepository.saveAndFlush(weaponEntity);

        return responseMapper.map(savedWeapon);
    }

    @Override
    public List<WeaponResponse> getAll() {
        LOGGER.info("Buscando todos as armas");
        List<Weapon> armas = weaponRepository.findAll();
        return armas.stream()
                .map(weapon -> responseMapper.map(weapon))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<WeaponResponse> update(Long id, WeaponRequest weaponRequest) {
        LOGGER.info("Atualizando o registro da arma");
        notNull(id, "ID Inválido");

        Optional<Weapon> optionalWeapon = weaponRepository.findById(id);
        if (optionalWeapon.isPresent()) {
            Weapon weapon = optionalWeapon.get();
            Weapon updatedWeapon = requestMapper.map(weaponRequest);
            updatedWeapon.setId(weapon.getId()); // Garantindo que o ID permaneça o mesmo
            weaponRepository.saveAndFlush(updatedWeapon);
            return Optional.of(responseMapper.map(updatedWeapon));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<WeaponResponse> get(Long id) {
        LOGGER.info("Buscando arma por ID");
        notNull(id, "ID Inválido");

        Optional<Weapon> optionalWeapon = weaponRepository.findById(id);
        return optionalWeapon.map(responseMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo arma por ID");
        notNull(id, "ID Inválido");

        try {
            weaponRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOGGER.warn("Erro ao remover arma {}", id);
            return false;
        }
    }
}

package br.com.hildo.login.service.impl;

import br.com.hildo.login.model.request.ProfileRequest;
import br.com.hildo.login.model.response.ProfileResponse;
import br.com.hildo.login.persistence.entity.Profile;
import br.com.hildo.login.persistence.repository.ProfileRepository;
import br.com.hildo.login.service.ProfileService;
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
public class ProfileServiceImpl implements ProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private Mapper<ProfileRequest, Profile> requestMapper;

    @Autowired
    private Mapper<Profile, ProfileResponse> responseMapper;


    @Override
    public ProfileResponse create(ProfileRequest profileRequest) {
        LOGGER.info("Criando o registro do perfil");
        notNull(profileRequest, "Request Inválida");

        Profile profileEntity = requestMapper.map(profileRequest);
        Profile savedProfile = profileRepository.saveAndFlush(profileEntity);

        return responseMapper.map(savedProfile);
    }

    @Override
    public List<ProfileResponse> getAll() {
        LOGGER.info("Buscando todos os perfis");
        List<Profile> perfis = profileRepository.findAll();
        return perfis.stream()
                .map(profile -> responseMapper.map(profile))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProfileResponse> update(Long id, ProfileRequest profileRequest) {
        LOGGER.info("Atualizando o registro do perfil");
        notNull(id, "ID Inválido");

        Optional<Profile> optionalProfile = profileRepository.findById(id);
        if (optionalProfile.isPresent()) {
            Profile profile = optionalProfile.get();
            Profile updatedProfile = requestMapper.map(profileRequest);
            updatedProfile.setId(profile.getId()); // Garantindo que o ID permaneça o mesmo
            profileRepository.saveAndFlush(updatedProfile);
            return Optional.of(responseMapper.map(updatedProfile));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ProfileResponse> get(Long id) {
        LOGGER.info("Buscando perfil por ID");
        notNull(id, "ID Inválido");

        Optional<Profile> optionalProfile = profileRepository.findById(id);
        return optionalProfile.map(responseMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo perfil por ID");
        notNull(id, "ID Inválido");

        try {
            profileRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOGGER.warn("Erro ao remover perfil {}", id);
            return false;
        }
    }
}

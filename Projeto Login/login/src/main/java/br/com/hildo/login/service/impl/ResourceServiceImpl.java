package br.com.hildo.login.service.impl;


import br.com.hildo.login.model.request.ResourceRequest;
import br.com.hildo.login.model.response.ResourceResponse;
import br.com.hildo.login.persistence.entity.Resource;
import br.com.hildo.login.persistence.repository.ResourceRepository;
import br.com.hildo.login.service.ResourceService;
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
public class ResourceServiceImpl implements ResourceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceService.class);

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private Mapper<ResourceRequest, Resource> requestMapper;

    @Autowired
    private Mapper<Resource, ResourceResponse> responseMapper;




    @Override
    public ResourceResponse create(ResourceRequest resourceRequest) {
        LOGGER.info("Criando o registro do recurso");
        notNull(resourceRequest, "Request Inválida");

        Resource resourceEntity = requestMapper.map(resourceRequest);
        Resource savedResource = resourceRepository.saveAndFlush(resourceEntity);

        return responseMapper.map(savedResource);
    }

    @Override
    public List<ResourceResponse> getAll() {
        LOGGER.info("Buscando todos os recursos");
        List<Resource> recursos = resourceRepository.findAll();
        return recursos.stream()
                .map(resource -> responseMapper.map(resource))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ResourceResponse> update(Long id, ResourceRequest resourceRequest) {
        LOGGER.info("Atualizando o registro do recurso");
        notNull(id, "ID Inválido");

        Optional<Resource> optionalResource = resourceRepository.findById(id);
        if (optionalResource.isPresent()) {
            Resource resource = optionalResource.get();
            Resource updatedResource = requestMapper.map(resourceRequest);
            updatedResource.setId(resource.getId()); // Garantindo que o ID permaneça o mesmo
            resourceRepository.saveAndFlush(updatedResource);
            return Optional.of(responseMapper.map(updatedResource));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ResourceResponse> get(Long id) {
        LOGGER.info("Buscando recurso por ID");
        notNull(id, "ID Inválido");

        Optional<Resource> optionalResource = resourceRepository.findById(id);
        return optionalResource.map(responseMapper::map);
    }

    @Override
    public boolean delete(Long id) {
        LOGGER.info("Removendo recurso por ID");
        notNull(id, "ID Inválido");

        try {
            resourceRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            LOGGER.warn("Erro ao remover recurso {}", id);
            return false;
        }
    }
    }

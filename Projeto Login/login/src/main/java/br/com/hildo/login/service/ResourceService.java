package br.com.hildo.login.service;

import br.com.hildo.login.model.request.ResourceRequest;
import br.com.hildo.login.model.response.ResourceResponse;




import java.util.List;
import java.util.Optional;


public interface ResourceService {

    ResourceResponse create(ResourceRequest resourceRequest);

    List<ResourceResponse> getAll();

    Optional<ResourceResponse> update(Long id, ResourceRequest resourceRequest);

    Optional<ResourceResponse> get(Long id);

    boolean delete(Long id);
}

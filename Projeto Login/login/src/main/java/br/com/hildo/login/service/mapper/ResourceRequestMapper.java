package br.com.hildo.login.service.mapper;

import br.com.hildo.login.model.request.ResourceRequest;
import br.com.hildo.login.persistence.entity.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceRequestMapper implements Mapper<ResourceRequest, Resource>{


    @Override
    public Resource map(ResourceRequest input) {
        if(input == null) {
            return null;
        }

        Resource resource = new Resource();

        resource.setName(input.getName());
        resource.setKey(input.getKey());



        return resource;
    }
}

package br.com.hildo.login.service.mapper;

import br.com.hildo.login.model.response.ResourceResponse;
import br.com.hildo.login.persistence.entity.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceResponseMapper implements Mapper<Resource, ResourceResponse> {


    @Override
    public ResourceResponse map(Resource input) {
        if(input == null){
            return  null;
        }

        ResourceResponse resourceResponse = new ResourceResponse();

        resourceResponse.setId(input.getId());
        resourceResponse.setName(input.getName());
        resourceResponse.setKey(input.getKey());



        return resourceResponse;
    }
}

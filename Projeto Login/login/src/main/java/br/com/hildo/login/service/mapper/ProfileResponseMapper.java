package br.com.hildo.login.service.mapper;

import br.com.hildo.login.model.response.ProfileResponse;
import br.com.hildo.login.persistence.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileResponseMapper implements Mapper<Profile, ProfileResponse> {
    @Override
    public ProfileResponse map(Profile input) {
        if(input == null){
            return  null;
        }

        ProfileResponse profileResponse = new ProfileResponse();

        profileResponse.setId(input.getId());
        profileResponse.setDescription(input.getDescription());




        return profileResponse;
    }
}

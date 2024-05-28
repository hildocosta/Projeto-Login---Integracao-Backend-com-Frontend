package br.com.hildo.login.service.mapper;

import br.com.hildo.login.model.request.ProfileRequest;
import br.com.hildo.login.persistence.entity.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileRequestMapper implements Mapper<ProfileRequest, Profile>{


    @Override
    public Profile map(ProfileRequest input) {
        if(input == null) {
            return null;
        }

        Profile profile = new Profile();

        profile.setDescription(input.getDescription());




        return profile;
    }
}

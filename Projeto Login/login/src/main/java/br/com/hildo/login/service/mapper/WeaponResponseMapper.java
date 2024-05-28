package br.com.hildo.login.service.mapper;


import br.com.hildo.login.model.response.WeaponResponse;
import br.com.hildo.login.persistence.entity.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponResponseMapper implements Mapper<Weapon, WeaponResponse> {


    @Override
    public WeaponResponse map(Weapon input) {
        if(input == null){
            return  null;
        }

        WeaponResponse weaponResponse = new WeaponResponse();

        weaponResponse.setId(input.getId());
        weaponResponse.setPatrimonio(input.getPatrimonio());
        weaponResponse.setTipo(input.getTipo());
        weaponResponse.setDistribuicao(input.getDistribuicao());
        weaponResponse.setPropriedade(input.getPropriedade());
        weaponResponse.setObservacao((input.getObservacao()));
        weaponResponse.setNumeroSerie(input.getNumeroSerie());
        weaponResponse.setMarca(input.getMarca());
        weaponResponse.setModelo(input.getModelo());
        weaponResponse.setCalibre(input.getCalibre());
        weaponResponse.setCano(input.getCano());
        weaponResponse.setRaias(input.getRaias());
        weaponResponse.setAcabamento(input.getAcabamento());


        return weaponResponse;
    }
}

package br.com.hildo.login.service.mapper;

import br.com.hildo.login.model.request.WeaponRequest;
import br.com.hildo.login.persistence.entity.Weapon;
import org.springframework.stereotype.Component;

@Component
public class WeaponRequestMapper implements Mapper<WeaponRequest, Weapon> {

    @Override
    public Weapon map(WeaponRequest input) {
        if(input == null) {
            return null;
        }

        Weapon weapon = new Weapon();

        weapon.setPatrimonio(input.getPatrimonio());
        weapon.setTipo(input.getTipo());
        weapon.setDistribuicao(input.getDistribuicao());
        weapon.setPropriedade(input.getPropriedade());
        weapon.setObservacao(input.getObservacao());
        weapon.setNumeroSerie(input.getNumeroSerie());
        weapon.setMarca(input.getMarca());
        weapon.setModelo(input.getModelo());
        weapon.setCalibre(input.getCalibre());
        weapon.setCano(input.getCano());
        weapon.setRaias(input.getRaias());
        weapon.setAcabamento(input.getAcabamento());



        return weapon;


    }

}

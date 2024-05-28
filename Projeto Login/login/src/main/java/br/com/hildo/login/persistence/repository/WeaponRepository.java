package br.com.hildo.login.persistence.repository;

import br.com.hildo.login.persistence.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}

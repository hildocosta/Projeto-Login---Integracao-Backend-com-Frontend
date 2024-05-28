package br.com.hildo.login.persistence.repository;

import br.com.hildo.login.persistence.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}

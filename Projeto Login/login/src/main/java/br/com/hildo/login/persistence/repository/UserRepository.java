package br.com.hildo.login.persistence.repository;


import br.com.hildo.login.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {


}


package br.com.hildo.login.persistence.repository;


import br.com.hildo.login.persistence.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ResourceRepository extends JpaRepository<Resource, Long> {


}


package br.com.pablovicz.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pablovicz.mvc.mudi.model.Access;

@Repository
public interface AccessRepository  extends JpaRepository<Access, Long>{

	
}

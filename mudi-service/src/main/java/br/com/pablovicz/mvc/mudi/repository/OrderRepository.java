package br.com.pablovicz.mvc.mudi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pablovicz.mvc.mudi.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	
}

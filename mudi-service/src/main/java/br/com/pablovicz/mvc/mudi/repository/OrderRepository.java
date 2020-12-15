package br.com.pablovicz.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pablovicz.mvc.mudi.model.Order;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
	public List<Order> findByStatus(OrderStatus status);
	
}

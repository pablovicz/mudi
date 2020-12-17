package br.com.pablovicz.mvc.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.pablovicz.mvc.mudi.model.Order;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("select o from Order o join o.user u where u.username =:username and o.status =:status")
	public List<Order> findByStatusAndUser(@Param("status") OrderStatus status, @Param("username") String username);

	@Cacheable("orders")
	public List<Order> findByStatus(OrderStatus status, Pageable page);

	@Query("select o from Order o join o.user u where u.username =:username")
	public List<Order> findAllByUser(@Param("username") String username);

}

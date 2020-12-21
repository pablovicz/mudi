package br.com.pablovicz.mvc.mudi.businessImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.model.Order;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;
import br.com.pablovicz.mvc.mudi.repository.OrderRepository;

@Service
public class OrderBusinessImpl implements OrderBusiness {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAll() {

		return (List<Order>) orderRepository.findAll();
	}

	public void save(Order order) {

		orderRepository.save(order);
	}

	public List<Order> getByStatus(OrderStatus status, Pageable page) {

		return orderRepository.findByStatus(status, page);
	}

	public List<Order> getByStatusAndUser(OrderStatus status, String username) {

		return orderRepository.findByStatusAndUser(status, username);
	}

	public List<Order> getAllByUser(String username) {

		return orderRepository.findAllByUser(username);
	}

	public Optional<Order> getById(Long id) {
		
		return orderRepository.findById(id);
	}

}

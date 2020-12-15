package br.com.pablovicz.mvc.mudi.businessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.model.Order;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;
import br.com.pablovicz.mvc.mudi.repository.OrderRepository;

@Service
public class OrderBusinessImpl implements OrderBusiness{
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<Order> getAll(){
		
		return (List<Order>) orderRepository.findAll();
	}
	
	public void save(Order order) {
		
		orderRepository.save(order);
	}

	
	public List<Order> getByStatus(OrderStatus status) {
		
		return orderRepository.findByStatus(status);
	}

}

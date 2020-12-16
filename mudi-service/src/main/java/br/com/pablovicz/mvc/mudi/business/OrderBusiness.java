package br.com.pablovicz.mvc.mudi.business;

import java.util.List;

import br.com.pablovicz.mvc.mudi.model.Order;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;

public interface OrderBusiness {
	
	public List<Order> getAll();
	
	public List<Order> getAllByUser(String username);
	
	public void save(Order order);

	public List<Order> getByStatus(OrderStatus status);
	
	public List<Order> getByStatusAndUser(OrderStatus status, String username);
	
	

}

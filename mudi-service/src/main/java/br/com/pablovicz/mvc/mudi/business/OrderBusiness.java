package br.com.pablovicz.mvc.mudi.business;

import java.util.List;

import br.com.pablovicz.mvc.mudi.model.Order;

public interface OrderBusiness {
	
	public List<Order> getAll();
	
	public void save(Order order);

}

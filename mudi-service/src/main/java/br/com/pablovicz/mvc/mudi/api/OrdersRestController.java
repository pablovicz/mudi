package br.com.pablovicz.mvc.mudi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.model.Order;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;

@RestController
@RequestMapping("/api/orders")
public class OrdersRestController {

	@Autowired
	private OrderBusiness orderBusiness;
	
	@GetMapping("/waiting")
	public List<Order> getOrdersWaitingForOffers(){
		
		Sort sort = Sort.by("orderDate").ascending();

		PageRequest page = PageRequest.of(0, 10, sort);
		
		return orderBusiness.getByStatus(OrderStatus.WAITING, page);
	}
	
	
}

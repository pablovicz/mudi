package br.com.pablovicz.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.dto.OrderDTO;
import br.com.pablovicz.mvc.mudi.model.Order;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderBusiness orderBusiness;
	
	@GetMapping("form")
	public String form(Model model) {

		return "order/form";
	}
	
	@PostMapping("new")
	public String save(OrderDTO orderDTO) {
		
		Order order = orderDTO.toOrder();
		
		orderBusiness.save(order);
		
		return "order/form";
	}
	

}

package br.com.pablovicz.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String form(OrderDTO orderDTO) {

		return "order/form";
	}

	@PostMapping("new")
	public String save(@Valid OrderDTO orderDTO, BindingResult result) {

		System.out.println(result);
		if (result.hasErrors()) {
			
			System.out.println("pedido com erro!");

			return "order/form";
		}

		Order order = orderDTO.toOrder();

		orderBusiness.save(order);

		return "redirect:/home";
	}

}

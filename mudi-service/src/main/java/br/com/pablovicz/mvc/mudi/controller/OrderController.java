package br.com.pablovicz.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.business.UserBusiness;
import br.com.pablovicz.mvc.mudi.dto.OrderDTO;
import br.com.pablovicz.mvc.mudi.model.Order;
import br.com.pablovicz.mvc.mudi.model.User;

@Controller
@RequestMapping("order")
public class OrderController {

	@Autowired
	private OrderBusiness orderBusiness;
	
	@Autowired
	private UserBusiness userBusiness;

	@GetMapping("form")
	public String form(OrderDTO orderDTO) {

		return "order/form";
	}

	@PostMapping("new")
	public String save(@Valid OrderDTO orderDTO, BindingResult result) {

		if (result.hasErrors()) {
			
			return "order/form";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		User user = userBusiness.findUser(username);
		
		
		Order order = orderDTO.toOrder();
		order.setUser(user);
		orderBusiness.save(order);

		return "redirect:/home";
	}

}

package br.com.pablovicz.mvc.mudi.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;

@Controller
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	private OrderBusiness orderBusiness;
	
	@GetMapping("order")
	public String home (Model model, Principal principal) {
		
		model.addAttribute("orders", orderBusiness.getAllByUser(principal.getName()));
		return "user/home";
	}
	
	@GetMapping("order/{status}")
	public String status (@PathVariable("status") String status, Model model) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("orders", orderBusiness.getByStatusAndUser(OrderStatus.valueOf(status.toUpperCase()), username));
		model.addAttribute("status",status);
		return "user/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/user/home";
	}

}

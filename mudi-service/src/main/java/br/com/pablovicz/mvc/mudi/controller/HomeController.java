package br.com.pablovicz.mvc.mudi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private OrderBusiness orderBusiness;
	
	@GetMapping
	public String home (Model model) {
		
		
		model.addAttribute("orders", orderBusiness.getAll());
		
		return "home";
	}
	
	@GetMapping("/{status}")
	public String status (@PathVariable("status") String status, Model model) {
		
		
		model.addAttribute("orders", orderBusiness.getByStatus(OrderStatus.valueOf(status.toUpperCase())));
		model.addAttribute("status",status);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
	

}

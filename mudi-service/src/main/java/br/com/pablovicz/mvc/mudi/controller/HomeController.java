package br.com.pablovicz.mvc.mudi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;

@Controller
public class HomeController {
	
	@Autowired
	private OrderBusiness orderBusiness;
	
	@GetMapping("/home")
	public String home (Model model) {
		
		
		model.addAttribute("orders", orderBusiness.getAll());
		
		return "home";
	}

}

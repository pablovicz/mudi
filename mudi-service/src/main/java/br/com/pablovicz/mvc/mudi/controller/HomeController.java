package br.com.pablovicz.mvc.mudi.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.pablovicz.mvc.mudi.model.Order;

@Controller
public class HomeController {
	
	
	@GetMapping("/home")
	public String home (Model model) {
		
		
		Order order = new Order();
		
		order.setName("Xiomi Redmi Note 9");
		order.setUrlImage("https://images-na.ssl-images-amazon.com/images/I/61VmUpCs7PL._AC_SL1000_.jpg");
		order.setUrlProduct("https://www.amazon.com.br/Xiaomi-Redmi-Note-128GB-4GB/dp/B088HJ3FCX/ref=sr_1_1?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=redmi+note+9&qid=1607629588&sr=8-1");
		order.setDescription("uma descrição qualquer para esse pedido");
		
		
		List<Order> orders = Arrays.asList(order);
		model.addAttribute("orders", orders);
		
		return "home";
	}

}

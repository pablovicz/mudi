package br.com.pablovicz.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.model.OrderStatus;

@Controller
@RequestMapping("home")
public class HomeController {

	@Autowired
	private OrderBusiness orderBusiness;

	@GetMapping
	public String home(Model model) {

		Sort sort = Sort.by("deliveredDate").descending();

		PageRequest page = PageRequest.of(0, 10, sort);

		model.addAttribute("orders", orderBusiness.getByStatus(OrderStatus.DELIVERED, page));
		return "home";
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}

}

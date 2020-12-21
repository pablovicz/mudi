package br.com.pablovicz.mvc.mudi.api;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pablovicz.mvc.mudi.business.OrderBusiness;
import br.com.pablovicz.mvc.mudi.dto.OfferDTO;
import br.com.pablovicz.mvc.mudi.model.Offer;
import br.com.pablovicz.mvc.mudi.model.Order;

@RestController
@RequestMapping("/api/offers")
public class OffersRestController {

	@Autowired
	private OrderBusiness orderBusiness;

	@PostMapping
	public Offer createOffer(@Valid @RequestBody OfferDTO offerDTO) {

		Optional<Order> searchedOrder = orderBusiness.getById(offerDTO.getOrderId());

		if (!searchedOrder.isPresent()) {
			return null;
		}

		Order order = searchedOrder.get();
		Offer newOffer = offerDTO.toOffer();
		newOffer.setOrder(order);
		order.getOffers().add(newOffer);
		orderBusiness.save(order);

		return newOffer;
	}

}

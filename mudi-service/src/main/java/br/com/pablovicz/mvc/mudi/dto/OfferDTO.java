package br.com.pablovicz.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.pablovicz.mvc.mudi.model.Offer;

public class OfferDTO {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Long orderId;

	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$", message = "Field must be in the currency type R$ 00.00")
	@NotNull
	private String price;

	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String deliveredDate;

	private String note;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(String deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Offer toOffer() {

		Offer offer = new Offer();

		offer.setNote(this.note);
		offer.setDeliveredDate(LocalDate.parse(this.deliveredDate, formatter));
		offer.setPrice(new BigDecimal(this.price));

		return offer;
	}

}

package br.com.pablovicz.mvc.mudi.dto;

import java.time.LocalDate;

import br.com.pablovicz.mvc.mudi.model.Order;

public class OrderDTO {
	
	private String productName;
	private String urlProduct;
	private String urlImage;
	private String description;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUrlProduct() {
		return urlProduct;
	}
	public void setUrlProduct(String urlProduct) {
		this.urlProduct = urlProduct;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Order toOrder() {
		
		Order order = new Order();
		order.setName(productName);
		order.setUrlProduct(urlProduct);
		order.setUrlImage(urlImage);
		order.setDescription(description);
		order.setDeliveryDate(LocalDate.now());
		
		return order;
	}

}

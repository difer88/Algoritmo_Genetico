package main.java.com.transportanalysis.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
* Provides the main attributes of the products
*
* @author  Diego Hortolani Fernandes <diegofernandes88@hotmail.com>
* @version 1.1
* @since   2018-08-09
*/
public class ProductVO {

	@JsonProperty("product_name")
	private String name;
	@JsonProperty("space_used")
	private Double space;
	@JsonProperty("product_value")
	private Double value;
	@JsonProperty("stock_quantity")
	private int quantity;
	
	public ProductVO() {
		
	}

	public ProductVO(String name, Double space, Double value, int quantity) {
		this.name = name;
		this.space = space;
		this.value = value;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSpace() {
		return space;
	}

	public void setSpace(Double space) {
		this.space = space;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}

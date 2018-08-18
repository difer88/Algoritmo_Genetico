package bean;

/**
* 
*
* @author  Diego Hortolani Fernandes <diegofernandes88@hotmail.com>
* @version 1.0
* @since   2018-08-09 
*/
public class Product {

	private String name;
	private Double space;
	private Double value;
	
	public Product() {
		
	}

	public Product(String name, Double space, Double value) {
		this.name = name;
		this.space = space;
		this.value = value;
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
	
}

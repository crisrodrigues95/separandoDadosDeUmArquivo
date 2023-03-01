package entities;

public class Product {
	
	private String name;
	private Integer quantity;
	private Double value;
	
	
	public Product() {
		
	}


	public Product(String name, Integer quantity, Double value) {
		this.name = name;
		this.quantity = quantity;
		this.value = value;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}
	
	public double totalValue() {
		return quantity*value;
	}


	@Override
	public String toString() {
		return name + ","+String.format("%.2f", totalValue());
	}
	
	
	
	
	

}

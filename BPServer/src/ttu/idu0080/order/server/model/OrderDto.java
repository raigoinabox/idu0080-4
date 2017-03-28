package ttu.idu0080.order.server.model;

import java.util.ArrayList;
import java.util.List;

import ttu.idu0080.order.server.Address;
import ttu.idu0080.order.server.Customer;
import ttu.idu0080.order.server.OrderProduct;

public class OrderDto {

	private int id;
	private float priceTotal;
	private Customer customer;
	private EnterpriseDto seller;
	private Address shippingAddress;
	private List<OrderProduct> orderProducts = new ArrayList<>();

	void setId(int value) {
		this.id = value;
	}

	void setPriceTotal(float value) {
		this.priceTotal = value;
	}

	void setCustomer(Customer value) {
		this.customer = value;
	}

	void setSeller(EnterpriseDto value) {
		this.seller = value;
	}

	void setShippingAddress(Address value) {
		this.shippingAddress = value;
	}

	public int getId() {
		return id;
	}

	public float getPriceTotal() {
		return priceTotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public EnterpriseDto getSeller() {
		return seller;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public List<OrderProduct> getOrderProducts() {
		return this.orderProducts;
	}
}

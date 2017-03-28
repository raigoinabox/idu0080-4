package ttu.idu0080.order.server.model;

import java.util.Collection;

import ttu.idu0080.order.server.EntAddress;

public class EnterpriseDto {

	private int id;
	private String name;
	private int percentFromOrder;
	private Collection<EntAddress> addresses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentFromOrder() {
		return percentFromOrder;
	}

	public void setPercentFromOrder(int percentFromOrder) {
		this.percentFromOrder = percentFromOrder;
	}

	public Collection<EntAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(Collection<EntAddress> addresses) {
		this.addresses = addresses;
	}
}

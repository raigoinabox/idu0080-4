package ttu.idu0080.order.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ttu.idu0080.order.server.Customer;

public class CustomerMapper {
	Map<Integer, Customer> customers = new HashMap<>();
	AddressMapper addressMapper;

	public CustomerMapper() {
		this(new AddressMapper());
	}

	public CustomerMapper(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}

	Customer fromResultSet(ResultSet resultSet) throws SQLException {
		Customer customer;

		int customerId = resultSet.getInt("customer");
		if (resultSet.wasNull()) {
			customer = null;
		} else if (customers.containsKey(customerId)) {
			customer = customers.get(customerId);
		} else {
			customer = new Customer();
			customer.setCustomer(customerId);
			customer.setFirstName(resultSet.getString("first_name"));
			customer.setLastName(resultSet.getString("last_name"));

			customers.put(customerId, customer);
		}

		addressMapper.fromResultSet(resultSet, customer);

		return customer;
	}
}

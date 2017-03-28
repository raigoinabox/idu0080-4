package ttu.idu0080.order.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ttu.idu0080.order.server.Address;
import ttu.idu0080.order.server.Customer;

public class AddressMapper extends Mapper {

	private Map<Integer, Address> addresses = new HashMap<>();
	private DbMapper<Address> addressMapper = new DbMapper<Address>() {

		@Override
		public Address fromResultSet(ResultSet resultSet, int id) throws SQLException {
			Address address = new Address();
			address.setAddress(id);
			address.setCountry(getString(resultSet, "country"));
			address.setCounty(getString(resultSet, "county"));
			address.setTownVillage(getString(resultSet, "town_village"));
			address.setStreetAddress(getString(resultSet, "street_address"));
			address.setZipcode(getString(resultSet, "zipcode"));
			return address;
		}
	};

	public AddressMapper() {
		super("address", "country", "county", "town_village", "street_address", "zipcode");
	}

	Address fromResultSet(ResultSet resultSet, Customer customer) throws SQLException {
		Address address;
		int addressId = getInt(resultSet, "address");
		if (resultSet.wasNull()) {
			address = null;
		} else if (addresses.containsKey(addressId)) {
			address = addresses.get(addressId);
		} else {
			address = addressMapper.fromResultSet(resultSet, addressId);

			addresses.put(addressId, address);
			if (customer != null) {
				customer.getAddresses().add(address);
			}
		}

		return address;
	}
}

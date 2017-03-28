package ttu.idu0080.order.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ttu.idu0080.order.server.EntAddress;

public class EntAddressMapper extends Mapper {

	private Map<Integer, EntAddress> addresses = new HashMap<>();

	public EntAddressMapper() {
		super("ent_address", "country", "county", "town_village", "street_address", "zipcode");
	}

	EntAddress fromResultSet(ResultSet resultSet, EnterpriseDto enterprise) throws SQLException {
		int addressId = getInt(resultSet, "ent_address");
		if (resultSet.wasNull()) {
			return null;
		} else if (addresses.containsKey(addressId)) {
			return addresses.get(addressId);
		} else {
			EntAddress address = new EntAddress();
			address.setAddress(addressId);
			address.setCountry(getString(resultSet, "country"));
			address.setCounty(getString(resultSet, "county"));
			address.setTownVillage(getString(resultSet, "town_village"));
			address.setStreetAddress(getString(resultSet, "street_address"));
			address.setZipcode(getString(resultSet, "zipcode"));

			addresses.put(addressId, address);
			enterprise.getAddresses().add(address);

			return address;
		}
	}
}

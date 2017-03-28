package ttu.idu0080.order.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ttu.idu0080.order.server.EntAddress;

public class EnterpriseMapper {
	private static final String ENTERPRISE_FIELDS = "enterprise, name, percent_from_order";

	private Map<Integer, EnterpriseDto> enterprises = new HashMap<>();
	private EntAddressMapper addressMapper;

	public EnterpriseMapper() {
		this(new EntAddressMapper());
	}

	public EnterpriseMapper(EntAddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}

	String getFields() {
		return ENTERPRISE_FIELDS + ", " + addressMapper.getFields();
	}

	EnterpriseDto fromResultSet(ResultSet resultSet) throws SQLException {
		EnterpriseDto seller;

		int sellerId = resultSet.getInt("enterprise");
		if (resultSet.wasNull()) {
			seller = null;
		} else if (enterprises.containsKey(sellerId)) {
			seller = enterprises.get(sellerId);
		} else {
			seller = new EnterpriseDto();
			seller.setId(sellerId);
			seller.setName(resultSet.getString("name"));
			seller.setPercentFromOrder(resultSet.getInt("percent_from_order"));
			seller.setAddresses(new ArrayList<EntAddress>());

			enterprises.put(sellerId, seller);
		}

		addressMapper.fromResultSet(resultSet, seller);

		return seller;
	}

	Collection<EnterpriseDto> getCollectedEnterprises() {
		return enterprises.values();
	}
}

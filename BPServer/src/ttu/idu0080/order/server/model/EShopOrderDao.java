package ttu.idu0080.order.server.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ttu.idu0080.order.server.Address;
import ttu.idu0080.order.server.Customer;

public class EShopOrderDao {

	private static final String CUSTOMER_FIELDS = "customer, first_name, last_name";

	public OrderDto getOrder(int id) {
		final Iterator<OrderDto> iterator = getOrders("eshop_order = " + id).iterator();
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}
	}

	private Collection<OrderDto> getOrders(String whereCondition) {
		String sqlWhere = "";
		if (!whereCondition.isEmpty()) {
			sqlWhere = " WHERE " + whereCondition;
		}

		AddressMapper customerAddressMapper = new AddressMapper();
		customerAddressMapper.setTable("address");

		EntAddressMapper entAddressMapper = new EntAddressMapper();
		entAddressMapper.setTable("ent_address");
		EnterpriseMapper enterpriseMapper = new EnterpriseMapper(entAddressMapper);

		AddressMapper shippingAddressMapper = new AddressMapper();
		shippingAddressMapper.setTable("shipping_address");

		OrderProductMapper productMapper = new OrderProductMapper();
		productMapper.setTable("order_product");

		String sql = "SELECT " + getOrderFields() + ", " + CUSTOMER_FIELDS + ", " + customerAddressMapper.getFields()
				+ ", " + productMapper.getFields() + ", " + enterpriseMapper.getFields() + ", "
				+ shippingAddressMapper.getFields() + " FROM eshop_order LEFT JOIN customer ON customer_fk = customer"
				+ " LEFT JOIN address ON customer = address.subject_fk"
				+ " LEFT JOIN enterprise ON seller_fk = enterprise"
				+ " LEFT JOIN ent_address ON enterprise = ent_address.subject_fk"
				+ " LEFT JOIN order_product ON eshop_order_fk = eshop_order"
				+ " LEFT JOIN address shipping_address ON shipping_address.address = shipping_address_fk" + sqlWhere;
		return getOrdersFromSql(sql, enterpriseMapper, shippingAddressMapper, customerAddressMapper, productMapper);
	}

	private String getOrderFields() {
		String[] fields = { "eshop_order", "price_total" };
		String fieldsString = SqlUtils.joinFields("eshop_order", fields);

		return fieldsString;
	}

	private Collection<OrderDto> getOrdersFromSql(String sql, EnterpriseMapper enterpriseMapper,
			AddressMapper shippingAddressMapper, AddressMapper customerAddressMapper,
			OrderProductMapper productMapper) {
		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			// ResultSetMetaData metaData = resultSet.getMetaData();
			// for (int i = 0; i < metaData.getColumnCount(); i++) {
			// System.out.println(metaData.getColumnLabel(i + 1));
			// }

			CustomerMapper customerMapper = new CustomerMapper(customerAddressMapper);

			Map<Integer, OrderDto> orders = new HashMap<>();
			while (resultSet.next()) {
				Customer customer = customerMapper.fromResultSet(resultSet);
				EnterpriseDto seller = enterpriseMapper.fromResultSet(resultSet);
				Address shippingAddress = shippingAddressMapper.fromResultSet(resultSet, null);

				OrderDto order;
				int orderId = resultSet.getInt("eshop_order");
				if (resultSet.wasNull()) {
					order = null;
				} else if (orders.containsKey(orderId)) {
					order = orders.get(orderId);
				} else {
					order = new OrderDto();
					order.setId(orderId);
					order.setPriceTotal(resultSet.getInt("price_total"));
					order.setCustomer(customer);
					order.setSeller(seller);
					order.setShippingAddress(shippingAddress);

					orders.put(orderId, order);
				}

				productMapper.fromResultSet(resultSet, order);
			}

			return orders.values();
		} catch (SQLException e) {
			System.out.println("ERROR: sql = " + sql);
			throw new RuntimeException(e);
		}
	}

	private static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql:veebiteenused", "raigo", "Hahehih0");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

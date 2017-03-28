package ttu.idu0080.order.server.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class EnterpriseDao {

	private static EnterpriseDao dao = new EnterpriseDao();

	public static EnterpriseDao getInstance() {
		return dao;
	}

	public EnterpriseDto getEnterpriseById(int id) {
		return getEnterprises("is_courier='Y' AND enterprise = " + id).iterator().next();
	}

	public Collection<EnterpriseDto> getEnterprises() {
		return getEnterprises("is_courier='Y'");
	}

	private Collection<EnterpriseDto> getEnterprises(String whereContent) {
		EntAddressMapper addressMapper = new EntAddressMapper();

		String sqlWhere = "";
		if (whereContent != null && !whereContent.isEmpty()) {
			sqlWhere = " WHERE " + whereContent;
		}
		String sql = "SELECT enterprise, name, percent_from_order, " + addressMapper.getFields()
				+ " FROM enterprise LEFT JOIN ent_address ON enterprise.enterprise = ent_address.subject_fk" + sqlWhere;
		return getEnterprises(sql, addressMapper);
	}

	private Collection<EnterpriseDto> getEnterprises(String sql, EntAddressMapper addressMapper) {

		try (Connection connection = getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			EnterpriseMapper mapper = new EnterpriseMapper(addressMapper);

			while (resultSet.next()) {
				mapper.fromResultSet(resultSet);
			}

			return mapper.getCollectedEnterprises();
		} catch (SQLException e) {
			System.out.println("SQL: " + sql);
			throw new RuntimeException(e);
		}
	}

	private Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql:veebiteenused", "raigo", "Hahehih0");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

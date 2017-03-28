package ttu.idu0080.order.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbMapper<T> {
	T fromResultSet(ResultSet resultSet, int id) throws SQLException;
}

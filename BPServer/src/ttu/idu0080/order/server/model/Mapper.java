package ttu.idu0080.order.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class Mapper {

	private String table = "";
	private Map<String, String> fields;

	public Mapper(String... fields) {
		this.fields = new HashMap<>();
		for (String field : fields) {
			this.fields.put(field, "UUID_" + UUID.randomUUID().toString().replace('-', '_'));
		}
	}

	void setTable(String value) {
		this.table = value;
	}

	String getFields() {
		String fieldsString = "";
		Iterator<Entry<String, String>> iterator = fields.entrySet().iterator();
		if (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			fieldsString = SqlUtils.constructField(table, entry.getKey(), entry.getValue());
		}
		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			fieldsString += ", " + SqlUtils.constructField(table, entry.getKey(), entry.getValue());
		}
		return fieldsString;
	}

	int getInt(ResultSet resultSet, String field) throws SQLException {
		return resultSet.getInt(getField(field));
	}

	float getFloat(ResultSet resultSet, String field) throws SQLException {
		return resultSet.getFloat(getField(field));
	}

	String getString(ResultSet resultSet, String field) throws SQLException {
		return resultSet.getString(getField(field));
	}

	private String getField(String field) {
		return fields.get(field);
	}
}
